package org.example.likelion_hackathon.dto.showDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Show;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDetailDto {
    private Long id;
    private String title;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxTickets;
    private List<ScheduleDetailDto> schedule;

    public static ShowDetailDto from(Show show) {
        return ShowDetailDto.builder()
                .id(show.getId())
                .title(show.getTitle())
                .location(show.getLocation())
                .startDate(show.getStartDate())
                .endDate(show.getEndDate())
                .maxTickets(show.getMaxTickets())
                .schedule(show.getScheduleList().stream().map(ScheduleDetailDto::from).toList())
                .build();
    }
}
