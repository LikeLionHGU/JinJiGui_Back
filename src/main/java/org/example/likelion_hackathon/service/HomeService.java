package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.HomeResponse;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.home.HomeClubDto;
import org.example.likelion_hackathon.dto.home.HomeShowDto;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final ShowRepository showRepository;
    private final ClubRepository clubRepository;

    public List<HomeShowDto> getShowDtoList() {
        List<Show> showList = showRepository.findAll();
        return showList.stream().map(HomeShowDto::from).toList();
    }

    public List<HomeResponse> getHomeResponses() {
        List<HomeShowDto> showDtoList = getShowDtoList();
        List<HomeResponse> homeResponseList = new ArrayList<>();
        for (HomeShowDto homeShowDto : showDtoList) {
            homeResponseList.add(HomeResponse.from(homeShowDto));
        }
        return homeResponseList;
    }
}
