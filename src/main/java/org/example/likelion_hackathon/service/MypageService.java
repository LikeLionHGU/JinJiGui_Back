package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final ReservationRepository reservationRepository;

    public List<UserReservationDto> getUserReservations(String userId) {
        List<UserReservationDto> reservations = reservationRepository.findAllByUser_Id(userId)
                .stream()
                .map(UserReservationDto::from)
                .collect(Collectors.toList());
        return reservations;
    }
}