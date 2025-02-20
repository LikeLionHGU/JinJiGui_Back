package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderDto {
    private HolderReservationDto reservation;
    private HolderUserDto user;
    private int totalCost;

    public static HolderDto from(Reservation reservation, User user, Schedule schedule, int totalCost) {
        return HolderDto.builder()
                .reservation(HolderReservationDto.from(reservation))
                .user(HolderUserDto.from(user))
                .totalCost(totalCost)
                .build();
    }
}
