package org.example.likelion_hackathon.dto.main;

import lombok.*;
import org.example.likelion_hackathon.domain.Club;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainClubDto {
    private Long id;
    private String name;
    private String category;

    public static MainClubDto from(Club club) {
        return MainClubDto.builder()
                .id(club.getId())
                .name(club.getName())
                .category(club.getCategory())
                .build();
    }
}
