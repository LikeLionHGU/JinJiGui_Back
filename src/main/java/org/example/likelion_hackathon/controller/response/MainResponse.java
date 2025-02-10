package org.example.likelion_hackathon.controller.response;

import lombok.*;
import org.example.likelion_hackathon.dto.home.HomeClubDto;
import org.example.likelion_hackathon.dto.home.HomeShowDto;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeResponse {
    private HomeShowDto show;

    public static HomeResponse from(HomeShowDto homeshowDto) {
        return HomeResponse.builder()
                .show(homeshowDto)
                .build();
    }
}
