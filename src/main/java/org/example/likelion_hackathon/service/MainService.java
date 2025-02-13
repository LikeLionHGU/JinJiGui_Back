package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.MainResponse;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.main.ClubMainDto;
import org.example.likelion_hackathon.dto.main.ShowMainDto;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {
    private final ShowRepository showRepository;

    public List<MainResponse> mainResponseList(){
        List<Show> shows = showRepository.findAll();
        List<Club> clubs = new ArrayList<>();
        for(Show show : shows){
            clubs.add(show.getClub());
        }

        List<MainResponse> mainResponseList = new ArrayList<>();
        for(int i=0 ; i<clubs.size() ; i++){
            MainResponse mainResponse = MainResponse.from(ShowMainDto.from(shows.get(i)), ClubMainDto.from(clubs.get(i)));
            mainResponseList.add(mainResponse);
        }

        return mainResponseList;
    }
}
