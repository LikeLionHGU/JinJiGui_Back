package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.service.MypageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myPage")
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    @GetMapping("/reservation")
    public ResponseEntity<UserReservationResponse> getUserReservations(HttpSession session) {
        String userId = (String) session.getAttribute("id");

        List<UserReservationDto> userReservationList = mypageService.getUserReservations(userId);
        UserReservationResponse userReservationResponse = UserReservationResponse.from(userReservationList);
        return ResponseEntity.ok(userReservationResponse);
    }

    }