package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUser_Id(String userId);

    Reservation getReservationBySchedule_IdAndUser_Id(Long scheduleId, String userId);

    List<Reservation> findReservationsBySchedule(Schedule schedule);
}
