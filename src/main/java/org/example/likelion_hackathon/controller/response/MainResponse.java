package org.example.likelion_hackathon.controller.response;

import jakarta.persistence.SequenceGenerators;
import lombok.*;
import org.example.likelion_hackathon.dto.main.MainDto;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainResponse {
    private List<MainDto> show_info;

    public static MainResponse from(List<MainDto> show_info) {
        return MainResponse.builder()
                .show_info(show_info)
                .build();
    }
}
