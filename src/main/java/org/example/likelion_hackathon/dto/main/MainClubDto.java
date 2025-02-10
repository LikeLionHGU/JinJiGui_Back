package org.example.likelion_hackathon.dto.home;

import lombok.*;
import org.example.likelion_hackathon.domain.Club;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeClubDto {
    private Long id;
    private String name;
    private String category;

    public static HomeClubDto from(Club club) {
        return HomeClubDto.builder()
                .id(club.getId())
                .name(club.getName())
                .category(club.getCategory())
                .build();
    }
}
