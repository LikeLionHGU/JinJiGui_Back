package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.manager.ManagerShowDto;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ShowRepository showRepository;
    private final ClubRepository clubRepository;

    public List<ManagerShowDto> managerShowDtoList(HttpSession session) {
        String id = (String) session.getAttribute("id");

        Club club = clubRepository.findClubByUser_Id(id);
        List<Show> showList = showRepository.findShowsByClub(club);

        return showList.stream().map(ManagerShowDto::from).toList();
    }
}
