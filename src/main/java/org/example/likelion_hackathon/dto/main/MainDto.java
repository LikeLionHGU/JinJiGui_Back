package org.example.likelion_hackathon.dto.main;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainDto {
    private ShowMainDto show;
    private ClubMainDto club;

    public static MainDto from(ShowMainDto show, ClubMainDto club) {
        return MainDto.builder()
                .show(show)
                .club(club)
                .build();
    }
}
