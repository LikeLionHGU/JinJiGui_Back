package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private int ticketNumber;
    private boolean isDeposit;

    public static Reservation from(User user, Schedule schedule, int ticketNumber) {
        return Reservation.builder()
                .user(user)
                .schedule(schedule)
                .ticketNumber(ticketNumber)
                .isDeposit(false)
                .build();
    }
}
