package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.myPage.UpdateResponse;
import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.domain.User;
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


    @GetMapping("/update")

    public ResponseEntity<UpdateResponse> updateUserInfo(HttpSession session) {
        String userId = (String) session.getAttribute("id");

        User user = mypageService.getUserById(userId);

        UpdateResponse response = UpdateResponse.from(user);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/save")

    public ResponseEntity<UpdateResponse> saveUserInfo(HttpSession session) {
        String userId = (String) session.getAttribute("id");

        User user = mypageService.getUserById(userId);
        UpdateResponse response = UpdateResponse.from(user);
        return ResponseEntity.ok(response);
    }


}