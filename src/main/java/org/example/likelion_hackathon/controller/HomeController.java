package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.MainResponse;
import org.example.likelion_hackathon.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final MainService homeService;

    @GetMapping("/main")
    public ResponseEntity<List<MainResponse>> mainHome() {
        List<MainResponse> homeResponses = new ArrayList<>();

        homeResponses = homeService.getHomeResponses();

        return ResponseEntity.ok().body(homeResponses);
    }
}
