package org.example.likelion_hackathon.dto.manager;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerShowDto {
    private Long id;
    private String title;


    public static ManagerShowDto from(Show show) {
        return ManagerShowDto.builder()
                .id(show.getId())
                .title(show.getTitle())
                .build();
    }
}
