package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.MypageRequest;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageService {
    private final ReservationRepository reservationRepository;

    private final UserRepository userRepository;

    public List<UserReservationDto> getUserReservations(String userId) {
        List<UserReservationDto> reservations = reservationRepository.findAllByUser_Id(userId)
                .stream()
                .map(UserReservationDto::from)
                .collect(Collectors.toList());
        return reservations;
    }

    public User getUserById(String userId) {

        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    public boolean update(MypageRequest mypageRequest, HttpSession session) {
        User user = userRepository.findById((String) session.getAttribute("id")).orElse(null);
        if(user == null) {
            return false;
        }
        user.setName(mypageRequest.getUserName());
        user.setPhoneNumber(mypageRequest.getPhoneNumber());
        user.setStdCode(mypageRequest.getStdCode());
        userRepository.save(user);
        return true;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}