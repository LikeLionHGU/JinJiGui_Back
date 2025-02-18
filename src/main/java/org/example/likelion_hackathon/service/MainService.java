package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.dto.main.MainDto;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.main.ShowMainDto;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final ShowRepository showRepository;

    public List<MainDto> mainResponseList(){
        List<Show> shows = showRepository.findAll();

        List<MainDto> mainResponseList = new ArrayList<>();
        for (Show show : shows) {
            MainDto mainResponse = MainDto.from(ShowMainDto.from(show));
            mainResponseList.add(mainResponse);
        }

        return mainResponseList;
    }
}
