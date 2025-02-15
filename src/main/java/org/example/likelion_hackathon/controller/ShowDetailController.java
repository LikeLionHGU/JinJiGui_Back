package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.ShowDetailResponse;
import org.example.likelion_hackathon.service.ShowDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShowDetailController {
    private final ShowDetailService showDetailService;

    @GetMapping("/show/{id}")
    public ResponseEntity<ShowDetailResponse> getShowDetail(@PathVariable Long id) {
        ShowDetailResponse showDetailResponse = showDetailService.returnShowDetailResponse(id);
        return ResponseEntity.ok().body(showDetailResponse);
    }
}
