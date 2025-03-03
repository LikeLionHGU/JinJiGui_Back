package org.example.likelion_hackathon.dto.main;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowMainDto {
    private Long id;
    private String poster;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String clubName;
    private String category;
    private int view;

    public static ShowMainDto from(Show show) {
        return ShowMainDto.builder()
                .id(show.getId())
                .poster(show.getPoster())
                .startDate(show.getStartDate())
                .endDate(show.getEndDate())
                .title(show.getTitle())
                .clubName(show.getClubName())
                .category(show.getCategory())
                .view(show.getView())
                .build();
    }
}
