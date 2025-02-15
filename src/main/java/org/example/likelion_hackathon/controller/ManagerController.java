package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.ManagerShowListResponse;
import org.example.likelion_hackathon.dto.manager.ManagerShowDto;
import org.example.likelion_hackathon.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/manager/show")
    public ResponseEntity<ManagerShowListResponse> getManagerShow(HttpSession session) {
        List<ManagerShowDto> managerShowDtoList = managerService.managerShowDtoList(session);
        ManagerShowListResponse managerShowListResponse = ManagerShowListResponse.from(managerShowDtoList);
        return ResponseEntity.ok().body(managerShowListResponse);
    }
}
