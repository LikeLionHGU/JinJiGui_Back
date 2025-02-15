package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.ReservationResponse;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.showDetail.ClubDetailDto;
import org.example.likelion_hackathon.dto.showDetail.ShowDetailDto;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowDetailService {
    private final ShowRepository showRepository;
    private final UserRepository userRepository;

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public boolean countUpView(Long id) {
        Show show = showRepository.findById(id).orElse(null);
        if (show != null) {
            int view = show.getView();
            show.setView(view + 1);
            showRepository.save(show);
            return true;
        } else {
            return false;
        }
    }

    public void Reservation (){

    }

    public ReservationResponse returnReservationResponse(Show show, HttpSession session, int ticketNumber){
        boolean available;
        int totalCost;
        String account = null;
        int remain_tickets;
        ReservationResponse reservationResponse = null;

        remain_tickets = canReserve(show, ticketNumber);
        if(remain_tickets < 0){
            available = false; totalCost = 0;
            reservationResponse = ReservationResponse.from(available, totalCost, account, remain_tickets);
        }
        else{
            available = true;
            //TODO : ticketNumber랑 회차 가격 곱해줘야함
            totalCost = ticketNumber;
        }
        return reservationResponse;
    }

    public int canReserve(Show show, int ticketNumber){
        int maxPeople = show.getMaxPeople();
        int applyPeople = show.getApplyPeople();

        return maxPeople - (applyPeople + ticketNumber);
    }
}
