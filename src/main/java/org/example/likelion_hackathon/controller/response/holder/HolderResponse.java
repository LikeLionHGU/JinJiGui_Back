package org.example.likelion_hackathon.controller.response.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.holder.HolderReservationDto;
import org.example.likelion_hackathon.dto.holder.HolderScheduleDto;
import org.example.likelion_hackathon.dto.holder.HolderUserDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderResponse {
    private HolderReservationDto reservation;
    private HolderUserDto user;
    private HolderScheduleDto schedule;
    private int totalCost;

    public static HolderResponse from(Reservation reservation, User user, Schedule schedule, int totalCost) {
        return HolderResponse.builder()
                .reservation(HolderReservationDto.from(reservation))
                .user(HolderUserDto.from(user))
                .schedule(HolderScheduleDto.from(schedule))
                .totalCost(totalCost)
                .build();
    }
}
