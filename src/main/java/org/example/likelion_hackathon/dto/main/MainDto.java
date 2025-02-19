package org.example.likelion_hackathon.dto.main;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainDto {
    private ShowMainDto show;

    public static MainDto from(ShowMainDto show) {
        return MainDto.builder()
                .show(show)
                .build();
    }
}
