package org.example.likelion_hackathon.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationRequest {
    private String userId;
    private Long scheduleId;
    private int ticketNumber;
}
