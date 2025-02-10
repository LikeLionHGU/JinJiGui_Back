package org.example.likelion_hackathon.controller.response;

import lombok.*;
import org.example.likelion_hackathon.dto.main.MainShowDto;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainResponse {
    private MainShowDto show;

    public static MainResponse from(MainShowDto homeshowDto) {
        return MainResponse.builder()
                .show(homeshowDto)
                .build();
    }
}
