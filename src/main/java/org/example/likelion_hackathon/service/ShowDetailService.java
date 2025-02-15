package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.ShowDetailResponse;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.showDetail.ScheduleDetailDto;
import org.example.likelion_hackathon.dto.showDetail.UserDetailDto;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowDetailService {
    private final ShowRepository showRepository;

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }

    public ShowDetailResponse returnShowDetailResponse(Long id) {
        Show show = getShowById(id);
        Club club = show.getClub();
        User user = club.getUser();
        List<Schedule> scheduleList = show.getScheduleList();

        String clubName = club.getName();
        UserDetailDto userDetailDto = UserDetailDto.from(user);
        List<ScheduleDetailDto> scheduleDetailDtoList = scheduleList.stream().map(ScheduleDetailDto::from).toList();

        return ShowDetailResponse.from(show, clubName, userDetailDto, scheduleDetailDtoList);
    }
}
