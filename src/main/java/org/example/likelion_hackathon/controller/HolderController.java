package org.example.likelion_hackathon.controller;

import com.amazonaws.Response;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.holder.HolderResponse;
import org.example.likelion_hackathon.dto.holder.HolderDto;
import org.example.likelion_hackathon.dto.holder.ReservationIdDto;
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
    public ResponseEntity<HolderResponse> getHolders(@PathVariable("scheduleId") Long scheduleId) {
        HolderResponse holderResponse = HolderResponse.from(holderService.makeHolderResponse(scheduleId), holderService.makeHolderResponseCsv(scheduleId), holderService.getSchedule(scheduleId));
        return ResponseEntity.ok().body(holderResponse);
    }

    @PostMapping("/manager/holder/save")
    public ResponseEntity<?> saveHolders(@RequestBody ReservationIdDto[] reservationList) {
        if (reservationList == null) {
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

    @PostMapping("/manager/holder/cancel")
    public ResponseEntity<?> cancelHolders(@RequestBody ReservationIdDto[] reservationList) {
        if (reservationList == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", false);
            response.put("message", "예매자가 선택되지 않았습니다");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        boolean check = holderService.updateIsDepositToCancel(reservationList);
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

    @PostMapping("/manager/holder/delete")
    public ResponseEntity<?> deleteHolders(@RequestBody ReservationIdDto[] reservationList) {
        if (reservationList == null || reservationList.length == 0) {
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
