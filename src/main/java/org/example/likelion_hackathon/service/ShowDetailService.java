package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.ReservationRequest;
import org.example.likelion_hackathon.controller.response.ShowDetailResponse;
import org.example.likelion_hackathon.domain.*;
import org.example.likelion_hackathon.controller.response.ReservationResponse;
import org.example.likelion_hackathon.dto.showDetail.ScheduleDetailDto;
import org.example.likelion_hackathon.dto.showDetail.UserDetailDto;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowDetailService {
    private final ShowRepository showRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final ReservationRepository reservationRepository;

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public Schedule getSchedule(Long id){
        return scheduleRepository.findById(id).orElse(null);
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

    public ReservationResponse returnReservationResponse(Long showId, HttpSession session, ReservationRequest reservationRequest){
        int totalCost;
        String account = null;
        int remain_tickets;
        ReservationResponse reservationResponse = null;
        int ticketNumber = reservationRequest.getTicketNumber();
        Long scheduleId = reservationRequest.getScheduleId();

        remain_tickets = canReserve(scheduleId, ticketNumber);
        if(remain_tickets < 0){
            totalCost = 0;
            reservationResponse = ReservationResponse.from(false, totalCost, account, remain_tickets);
        }
        else{
            reservation(session, showId, scheduleId, ticketNumber);

            totalCost = ticketNumber * getTicketCost(scheduleId);
            account = getAccount(showId);

            reservationResponse = ReservationResponse.from(true, totalCost, account, remain_tickets);
        }
        return reservationResponse;
    }

    public int canReserve(Long id, int ticketNumber){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        int maxPeople = schedule.getMaxPeople();
        int applyPeople = schedule.getApplyPeople();

        return maxPeople - (applyPeople + ticketNumber);
    }

    public void reservation(HttpSession session, Long showId, Long scheduleId, int ticketNumber){
        String userId = (String) session.getAttribute("id");
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("no such user"));
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        Reservation reservation = Reservation.from(user, schedule, ticketNumber);

        reservationRepository.save(reservation);
    }

    public int getTicketCost(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        return schedule.getCost();
    }

    public String getAccount(Long showId){
        Show show = showRepository.findById(showId).orElseThrow(() -> new IllegalArgumentException("no such show"));
        return show.getAccount();
    }
}
