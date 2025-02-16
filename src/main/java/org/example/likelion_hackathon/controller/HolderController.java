package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.HolderRequest;
import org.example.likelion_hackathon.controller.response.holder.HolderResponse;
import org.example.likelion_hackathon.dto.holder.ReservationIdDto;
import org.example.likelion_hackathon.dto.myPage.ReservationList.ReservationDto;
import org.example.likelion_hackathon.service.HolderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HolderController {
    private final HolderService holderService;

    @GetMapping("/manager/holder/{scheduleId}")
    public ResponseEntity<List<HolderResponse>> getHolders(@PathVariable("scheduleId") Long scheduleId) {
        return ResponseEntity.ok().body(holderService.makeHolderResponse(scheduleId));
    }

    @PatchMapping("/manager/holder/save")
    public ResponseEntity<?> saveHolders(@RequestBody List<ReservationIdDto> reservationList) {
        if (reservationList == null || reservationList.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", false);
            response.put("message", "예매자가 선택되지 않았습니다");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        boolean check = holderService.updateIsDepositToTrue(reservationList);
        if (check) {
            Map<String, Boolean> response = Collections.singletonMap("status", true);
            return ResponseEntity.ok().body(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", false);
            response.put("message", "정상적으로 저장되지 않았습니다");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PatchMapping("/manager/holder/delete")
    public ResponseEntity<?> deleteHolders(@RequestBody List<ReservationIdDto> reservationList) {
        if (reservationList == null || reservationList.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", false);
            response.put("message", "예매자가 선택되지 않았습니다");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        boolean check = holderService.deleteReservations(reservationList);
        if (check) {
            Map<String, Boolean> response = Collections.singletonMap("status", true);
            return ResponseEntity.ok().body(response);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", false);
            response.put("message", "정상적으로 삭제되지 않았습니다");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
