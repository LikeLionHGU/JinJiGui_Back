package org.example.likelion_hackathon.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.domain.User;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private boolean available;
    private int totalCost;
    private String account;
    private int remain_tickets;

    public static ReservationResponse from(boolean available, int totalCost, String account, int remain_tickets) {
        return ReservationResponse.builder()
                .available(available)
                .totalCost(totalCost)
                .account(account)
                .remain_tickets(remain_tickets)
                .build();
    }
}
