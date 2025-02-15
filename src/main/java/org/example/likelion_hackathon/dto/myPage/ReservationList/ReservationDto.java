package org.example.likelion_hackathon.dto.myPage.ReservationList;

import org.example.likelion_hackathon.domain.Reservation;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private boolean isDeposit;

    public static ReservationDto from(Reservation reservation) {
        return new ReservationDto(reservation.isDeposit());
    }

}
