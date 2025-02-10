package org.example.likelion_hackathon.dto.home;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HomeShowDto {
    private Long id;
    private String poster;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private HomeClubDto club;

    public static HomeShowDto from(Show show){
        return HomeShowDto.builder()
                .id(show.getId())
                .poster(show.getPoster())
                .startDate(show.getStartDate())
                .endDate(show.getEndDate())
                .title(show.getTitle())
                .club(HomeClubDto.from(show.getClub()))
                .build();
    }
}
