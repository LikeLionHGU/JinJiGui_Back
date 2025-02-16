package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.HolderRequest;
import org.example.likelion_hackathon.controller.response.holder.HolderResponse;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.holder.ReservationIdDto;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolderService {
    private final ReservationRepository reservationRepository;
    private final ScheduleRepository scheduleRepository;

    public List<HolderResponse> makeHolderResponse(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        List<Reservation> reservationList = reservationRepository.findReservationsBySchedule(schedule);
        List<User> userList = new ArrayList<>();
        List<Integer> totalCostList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            userList.add(reservation.getUser());
            totalCostList.add(schedule.getCost() * reservation.getTicketNumber());
        }

        List<HolderResponse> holderResponseList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            HolderResponse holderResponse = HolderResponse.from(reservationList.get(i), userList.get(i), schedule, totalCostList.get(i));
            holderResponseList.add(holderResponse);
        }
        return holderResponseList;
    }

    public boolean updateIsDepositToTrue(List<ReservationIdDto> reservationList) {
        for (ReservationIdDto reservationIdDto : reservationList) {
            Long id = reservationIdDto.getReservationId();
            Reservation reservation = reservationRepository.findById(id).orElse(null);
            if (reservation == null) {
                return false;
            }
            reservation.setDeposit(true);
            reservationRepository.save(reservation);
        }
        return true;
    }
}
