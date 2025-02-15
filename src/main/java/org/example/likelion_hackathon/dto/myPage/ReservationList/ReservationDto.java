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
public class ReservationDto {
    private boolean isDeposit;

    public static ReservationDto from(Reservation reservation) {
        return ReservationDto.builder()
                .isDeposit(reservation.isDeposit())
                .build();
    }
}

