package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.myPage.UserReservationResponse;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final ReservationRepository reservationRepository;

    public UserReservationResponse getUserReservations(String userId) {
        List<Reservation> reservations = reservationRepository.findAllByUser_Id(userId);
        List<UserReservationDto> userReservations = reservations.stream()
                .map(reservation -> UserReservationDto.from(reservation))
                .collect(Collectors.toList());
        return UserReservationResponse.from(userReservations);
    }
}