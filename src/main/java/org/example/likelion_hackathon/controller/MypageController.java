package org.example.likelion_hackathon.controller;


import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.service.MypageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myPage")
public class MypageController {
    private final MypageService mypageService;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping("/reservation")
    public ResponseEntity<UserReservationResponse> getUserReservations() {
        List<UserReservationDto> user_reservation_list = mypageService.getUserReservations();
        UserReservationResponse user_reservation_response = UserReservationResponse.from(user_reservation_list);

//        UserReservationResponse user_reservation_response1 = new UserReservationResponse();
//        user_reservation_response1.setUser_reservation_list(user_reservation_list);
        return ResponseEntity.ok(user_reservation_response);
    }

    @GetMapping("/edit")
    public ResponseEntity<> getUserInfo() {
        return ResponseEntity.ok(mypageService.getUserInfo());
    }

    @PatchMapping("/save")
    public ResponseEntity<> saveUserInfo(@RequestBody MypageUserRequest request) {
        return ResponseEntity.ok(mypageService.saveUserInfo(request));
    }
}