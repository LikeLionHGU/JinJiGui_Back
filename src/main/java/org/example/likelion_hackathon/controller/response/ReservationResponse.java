package org.example.likelion_hackathon.controller.response;

import lombok.*;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.domain.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private boolean available;
    private int totalCost;
    private String account;
    private int remain_tickets;
    private String qrImage;

    public static ReservationResponse from(boolean available, int totalCost, String account, int remain_tickets, String qrImage) {
        return ReservationResponse.builder()
                .available(available)
                .totalCost(totalCost)
                .account(account)
                .remain_tickets(remain_tickets)
                .qrImage(qrImage)
                .build();
    }
}
