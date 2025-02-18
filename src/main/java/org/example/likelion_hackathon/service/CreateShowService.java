package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.CreateShowRequest;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateShowService {
    private final ShowRepository showRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public void saveShowAndSchedule(CreateShowRequest createShowRequest, String poster, String qrCode, HttpSession session) {
        Show show = Show.from(createShowRequest, poster, qrCode);
        show.setUser(userRepository.findById((String) session.getAttribute("id")).orElseThrow(() -> new IllegalArgumentException("no login")));
        showRepository.save(show);

        List<CreateScheduleDto> scheduleDtoList = createShowRequest.getSchedule();
        List<Schedule> scheduleList = scheduleDtoList.stream().map(Schedule::from).toList();
        for (Schedule schedule : scheduleList) {
            schedule.setShow(show);
            scheduleRepository.save(schedule);
        }

    }
}
