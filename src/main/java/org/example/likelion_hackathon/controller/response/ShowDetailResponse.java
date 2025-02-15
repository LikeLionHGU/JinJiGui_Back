package org.example.likelion_hackathon.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.showDetail.ScheduleDetailDto;
import org.example.likelion_hackathon.dto.showDetail.UserDetailDto;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDetailResponse {
    private Long id;
    private String title;
    private String clubName;
    private String content;
    private String showPic;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxTickets;
    private int runTime;
    private UserDetailDto user;
    private List<ScheduleDetailDto> schedule;

    public static ShowDetailResponse from(Show show, String clubName, UserDetailDto user, List<ScheduleDetailDto> schedule) {
        return ShowDetailResponse.builder()
                .id(show.getId())
                .title(show.getTitle())
                .clubName(clubName)
                .content(show.getContent())
                .showPic(show.getPoster())
                .location(show.getLocation())
                .startDate(show.getStartDate())
                .endDate(show.getEndDate())
                .maxTickets(show.getMaxTickets())
                .runTime(show.getRuntime())
                .user(user)
                .schedule(schedule)
                .build();
    }
}
