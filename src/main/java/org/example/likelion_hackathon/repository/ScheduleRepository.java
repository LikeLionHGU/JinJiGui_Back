package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
