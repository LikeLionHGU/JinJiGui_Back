package org.example.likelion_hackathon.dto.main;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainShowDto {
    private Long id;
    private String poster;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private MainClubDto club;

    public static MainShowDto from(Show show){
        return MainShowDto.builder()
                .id(show.getId())
                .poster(show.getPoster())
                .startDate(show.getStartDate())
                .endDate(show.getEndDate())
                .title(show.getTitle())
                .club(MainClubDto.from(show.getClub()))
                .build();
    }
}
