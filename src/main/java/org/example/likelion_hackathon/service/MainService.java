package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.MainResponse;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.main.MainShowDto;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final ShowRepository showRepository;
    private final ClubRepository clubRepository;

    public List<MainShowDto> getShowDtoList() {
        List<Show> showList = showRepository.findAll();
        return showList.stream().map(MainShowDto::from).toList();
    }

    public List<MainResponse> getHomeResponses() {
        List<MainShowDto> showDtoList = getShowDtoList();
        List<MainResponse> homeResponseList = new ArrayList<>();
        for (MainShowDto homeShowDto : showDtoList) {
            homeResponseList.add(MainResponse.from(homeShowDto));
        }
        return homeResponseList;
    }
}
