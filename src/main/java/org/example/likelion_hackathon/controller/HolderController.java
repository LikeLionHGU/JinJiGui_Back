package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.holder.HolderResponse;
import org.example.likelion_hackathon.service.HolderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HolderController {
    private final HolderService holderService;

    @GetMapping("/manager/holder/{scheduleId}")
    public List<HolderResponse> getHolders(@PathVariable("scheduleId") Long scheduleId) {
        return holderService.makeHolderResponse(scheduleId);
    }
}
