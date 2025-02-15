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
    private ShowDto show;
    private ScheduleDto schedule;
    private ReservationDto reservation;
    private int totalCost;

    public static UserReservationDto from(Reservation reservation) {
        return UserReservationDto.builder()
                .show(ShowDto.from(reservation.getSchedule().getShow()))
                .schedule(ScheduleDto.from(reservation.getSchedule()))
                .reservation(ReservationDto.from(reservation))
                .totalCost(reservation.getSchedule().getCost())
                .build();
    }
}