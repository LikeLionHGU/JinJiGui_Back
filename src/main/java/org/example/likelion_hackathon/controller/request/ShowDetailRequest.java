package org.example.likelion_hackathon.controller.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShowDetailRequest {
    private String userId;
    private Long showId;
}
