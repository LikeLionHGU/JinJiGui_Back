package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderShowDto {
    private String title;

    public static HolderShowDto from(Show show) {
        return HolderShowDto.builder()
                .title(show.getTitle())
                .build();
    }
}
