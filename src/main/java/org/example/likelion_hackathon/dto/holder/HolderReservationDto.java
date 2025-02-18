package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Reservation;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderReservationDto {
    private Long id;
    private int ticketNumber;
    private String isDeposit;

    public static HolderReservationDto from(Reservation reservation) {
        return HolderReservationDto.builder()
                .id(reservation.getId())
                .ticketNumber(reservation.getTicketNumber())
                .isDeposit(reservation.isDeposit()?"O":"X")
                .build();
    }
}
