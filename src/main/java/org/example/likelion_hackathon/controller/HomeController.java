package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.HomeResponse;
import org.example.likelion_hackathon.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping("/home")
    public ResponseEntity<List<HomeResponse>> home() {
        List<HomeResponse> homeResponses = new ArrayList<>();

        homeResponses = homeService.getHomeResponses();

        return ResponseEntity.ok().body(homeResponses);
    }
}
