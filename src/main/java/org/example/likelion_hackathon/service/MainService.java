package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.dto.main.MainDto;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.main.ShowMainDto;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<MainDto> topFour() {
        // showRepository.findAll()이 null을 반환할 경우를 대비해 방어 코드 추가
        List<Show> shows = Optional.ofNullable(showRepository.findAll()).orElse(Collections.emptyList());

        // 조회수를 기준으로 내림차순 정렬 (조회수가 같으면 id를 기준으로 추가 정렬)
        List<Show> sortedShows = shows.stream()
                .sorted((s1, s2) -> {
                    int compare = Integer.compare(s2.getView(), s1.getView());
                    return (compare != 0) ? compare : Long.compare(s2.getId(), s1.getId());
                })
                .limit(6) // 상위 6개만 선택
                .toList();

        // Show 객체를 MainDto로 변환하여 반환
        List<MainDto> mainResponseList = new ArrayList<>();
        for (Show show : sortedShows) {
            if (show != null) {
                ShowMainDto showMainDto = ShowMainDto.from(show);
                if (showMainDto != null) {
                    MainDto mainDto = MainDto.from(showMainDto);
                    if (mainDto != null) {
                        mainResponseList.add(mainDto);
                    }
                }
            }
        }
        return mainResponseList;
    }

}
