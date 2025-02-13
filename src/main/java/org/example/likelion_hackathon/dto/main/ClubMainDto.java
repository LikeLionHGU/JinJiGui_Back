package org.example.likelion_hackathon.dto.main;

import lombok.*;
import org.example.likelion_hackathon.domain.Club;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubMainDto {
    private Long id;
    private String name;
    private String category;

    public static ClubMainDto from(Club club) {
        return ClubMainDto.builder()
                .id(club.getId())
                .name(club.getName())
                .category(club.getCategory())
                .build();
    }
}
