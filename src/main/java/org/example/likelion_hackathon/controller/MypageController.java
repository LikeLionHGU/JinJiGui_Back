package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.MypageRequest;
import org.example.likelion_hackathon.controller.response.myPage.UpdateResponse;
import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.dto.myPage.TurnThePage.Update;
import org.example.likelion_hackathon.service.MypageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    @GetMapping("/mypage/reservation/{userId}")
    public ResponseEntity<UserReservationResponse> getUserReservations(@PathVariable String userId) {
        List<UserReservationDto> userReservationList = mypageService.getUserReservations(userId);
        UserReservationResponse userReservationResponse = UserReservationResponse.from(userReservationList);
        return ResponseEntity.ok().body(userReservationResponse);
    }


    @GetMapping("/mypage/update/{userId}")
    public ResponseEntity<UpdateResponse> updateUserInfo(@PathVariable String userId) {
        if(userId == null) {
            System.out.println("<<userId is null>>");
        }else{
            System.out.println("<<userId: " + userId + "<<");
        }

        User user = mypageService.getUserById(userId);
        if(user == null) {
            System.out.println("<<Mypage Update is Null!!!>>");
        }else{
            System.out.println("<<Mypage Update: " + user.toString());
        }

//        UpdateResponse response = UpdateResponse.from(user);

        Update update = Update.from(user.getName(), user.getPhoneNumber(), user.getStdCode());
        UpdateResponse updateResponse = UpdateResponse.from(user);
        return ResponseEntity.ok().body(updateResponse);
    }

    @PutMapping("/mypage/save/{userId}")
    public ResponseEntity<UpdateResponse> saveUserInfo(@PathVariable String userId, @RequestBody UpdateResponse updateResponse) {
        System.out.println("error1");
        User user = mypageService.getUserById(userId);
        System.out.println("error2");
        user.setName(updateResponse.getUser().getUserName());
        System.out.println("error3");
        user.setPhoneNumber(updateResponse.getUser().getPhoneNumber());
        System.out.println("error4");
        user.setStdCode(updateResponse.getUser().getStdCode());
        System.out.println("error5");
        mypageService.saveUser(user);
        System.out.println("error6");
        return ResponseEntity.ok().body(UpdateResponse.from(user));
    }

    @PutMapping("/add-info/{userId}")
    public ResponseEntity<UpdateResponse> inputInfo(@PathVariable String userId, @RequestBody UpdateResponse updateResponse){
//        String userId = (String) session.getAttribute("id");
        User user = mypageService.getUserById(userId);
        user.setName(updateResponse.getUser().getUserName());
        user.setPhoneNumber(updateResponse.getUser().getPhoneNumber());
        user.setStdCode(updateResponse.getUser().getStdCode());
        mypageService.saveUser(user);
        return ResponseEntity.ok().body(UpdateResponse.from(user));
    }
}