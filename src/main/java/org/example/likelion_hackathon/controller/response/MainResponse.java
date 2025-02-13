package org.example.likelion_hackathon.controller.response;

import lombok.*;
import org.example.likelion_hackathon.dto.main.ClubMainDto;
import org.example.likelion_hackathon.dto.main.ShowMainDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainResponse {
    private ShowMainDto show;
    private ClubMainDto club;

    public static MainResponse from(ShowMainDto show, ClubMainDto club) {
        return MainResponse.builder()
                .show(show)
                .club(club)
                .build();
    }
}
