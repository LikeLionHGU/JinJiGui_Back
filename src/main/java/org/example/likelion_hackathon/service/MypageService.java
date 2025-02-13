package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final ReservationRepository reservationRepository;

    public UserReservationResponse getUserReservations(String userId) {
        // TODO: 데이터베이스에서 해당 userId의 예약 목록을 조회하여 UserReservationResponse 변환 후 반환
        return new UserReservationResponse();
    }
}
