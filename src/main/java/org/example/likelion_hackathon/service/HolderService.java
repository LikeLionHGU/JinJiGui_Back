package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.dto.holder.CsvDto;
import org.example.likelion_hackathon.dto.holder.HolderDto;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.holder.ReservationIdDto;
import org.example.likelion_hackathon.repository.ReservationRepository;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolderService {
    private final ReservationRepository reservationRepository;
    private final ScheduleRepository scheduleRepository;

    public List<HolderDto> makeHolderResponse(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        List<Reservation> reservationList = reservationRepository.findReservationsBySchedule(schedule);
        List<User> userList = new ArrayList<>();
        List<Integer> totalCostList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            userList.add(reservation.getUser());
            totalCostList.add(schedule.getCost() * reservation.getTicketNumber());
        }

        List<HolderDto> holderResponseList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            HolderDto holderResponse = HolderDto.from(reservationList.get(i), userList.get(i), schedule, totalCostList.get(i));
            holderResponseList.add(holderResponse);
        }
        return holderResponseList;
    }

    public List<CsvDto> makeHolderResponseCsv(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
        List<Reservation> reservationList = reservationRepository.findReservationsBySchedule(schedule);
        List<User> userList = new ArrayList<>();
        List<Integer> totalCostList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            userList.add(reservation.getUser());
            totalCostList.add(schedule.getCost() * reservation.getTicketNumber());
        }

        List<CsvDto> csvDtoList = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            CsvDto csvDto = CsvDto.from(reservationList.get(i), userList.get(i), schedule, totalCostList.get(i));
            csvDtoList.add(csvDto);
        }
        return csvDtoList;
    }

    public boolean updateIsDepositToTrue(ReservationIdDto[] reservationList) {
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

    public boolean updateIsDepositToCancel(ReservationIdDto[] reservationList){
        for (ReservationIdDto reservationIdDto : reservationList) {
            Long id = reservationIdDto.getReservationId();
            Reservation reservation = reservationRepository.findById(id).orElse(null);
            if (reservation == null) {
                return false;
            }
            reservation.setDeposit(false);
            reservationRepository.save(reservation);
        }
        return true;
    }

    public boolean deleteReservations(ReservationIdDto[] reservationList) {
        for (ReservationIdDto reservationIdDto : reservationList) {
            Long id = reservationIdDto.getReservationId();
            Reservation reservation = reservationRepository.findById(id).orElse(null);
            if (reservation == null) {
                return false;
            }
            reservationRepository.delete(reservation);
        }
        Reservation reservation = reservationRepository.findById(reservationList[0].getReservationId()).orElse(null);
        Schedule selectedSchedule =  reservation.getSchedule();
        selectedSchedule.setApplyPeople(selectedSchedule.getApplyPeople() - reservationList.length);
        scheduleRepository.save(selectedSchedule);
        return true;
    }

    public Schedule getSchedule(Long scheduleId){
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("no such schedule"));
    }
}
