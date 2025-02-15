package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.CreateShowRequest;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateShowService {
    private final ShowRepository showRepository;
    private final ClubRepository clubRepository;
    private final ScheduleRepository scheduleRepository;

    public void saveShowAndSchedule(CreateShowRequest createShowRequest, String poster, HttpSession session) {
        Show show = Show.from(createShowRequest, poster);
        linkShowToClub(session, show);
        showRepository.save(show);

        List<CreateScheduleDto> scheduleDtoList = createShowRequest.getSchedule();
        List<Schedule> scheduleList = scheduleDtoList.stream().map(Schedule::from).toList();
        for (Schedule schedule : scheduleList) {
            schedule.setShow(show);
            scheduleRepository.save(schedule);
        }

    }

    public void linkShowToClub(HttpSession session, Show show) {
        String id = (String) session.getAttribute("id");
        Club club = clubRepository.findClubByUser_Id(id);
        show.setClub(club);
    }
}
