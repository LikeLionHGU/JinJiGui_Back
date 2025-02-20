package org.example.likelion_hackathon.dto.myPage.ReservationList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Reservation;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReservationDto {
    private int primary;
    private ShowDto show;
    private ScheduleDto schedule;
    private ReservationDto reservation;
    private int totalCost;
    private String poster;
    private int ticketNumber;

    public static UserReservationDto from(Reservation reservation) {
        int random = (int) (Math.random()*1000);
        return UserReservationDto.builder()
                .primary(random)
                .show(ShowDto.from(reservation.getSchedule().getShow()))
                .schedule(ScheduleDto.from(reservation.getSchedule()))
                .reservation(ReservationDto.from(reservation))
                .totalCost(reservation.getSchedule().getCost() * reservation.getTicketNumber())
                .poster(reservation.getSchedule().getShow().getPoster())
                .ticketNumber(reservation.getTicketNumber())
                .build();
    }
}