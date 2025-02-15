package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUser_Id(String userId);
}
