package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.MainResponse;
import org.example.likelion_hackathon.dto.main.MainDto;
import org.example.likelion_hackathon.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/main")
    public ResponseEntity<MainResponse> mainPage() {
        List<MainDto> mainResponseList = mainService.mainResponseList();
        MainResponse mainResponse = MainResponse.from(mainResponseList);
        return ResponseEntity.ok().body(mainResponse);
    }
}
