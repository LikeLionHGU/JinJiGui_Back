package org.example.likelion_hackathon.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.showDetail.ClubDetailDto;
import org.example.likelion_hackathon.dto.showDetail.ShowDetailDto;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDetailResponse {
    private ShowDetailDto show;
    private ClubDetailDto club;

    public static ShowDetailResponse from(Show show) {
        return ShowDetailResponse.builder()
                .show(ShowDetailDto.from(show))
                .club(ClubDetailDto.from(show.getClub()))
                .build();
    }
}
