package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.ManagerShowListResponse;
import org.example.likelion_hackathon.dto.manager.ManagerShowDto;
import org.example.likelion_hackathon.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/manager/show/{userId}")
    public ResponseEntity<ManagerShowListResponse> getManagerShow(@PathVariable String userId, HttpSession session) {
        System.out.println("Id >> " + userId);
        List<ManagerShowDto> managerShowDtoList = managerService.managerShowDtoList(userId);
        ManagerShowListResponse managerShowListResponse = ManagerShowListResponse.from(managerShowDtoList);
        return ResponseEntity.ok().body(managerShowListResponse);
    }

    @DeleteMapping("/manager/show/{scheduleId}")
    public ResponseEntity<?> deleteManagerShow(@PathVariable Long scheduleId) {
        boolean check = managerService.deleteSelectedShow(scheduleId);
        if (check) {
            return ResponseEntity.ok().body(Collections.singletonMap("status",true));
        } else{
            Map<String, Object> badResponse = new HashMap<>();
            badResponse.put("status",false);
            badResponse.put("message","동아리 삭제에 실패했습니다");
            return ResponseEntity.ok().body(badResponse);
        }
    }
}
