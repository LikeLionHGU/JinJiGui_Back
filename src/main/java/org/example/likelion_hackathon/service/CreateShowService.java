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

    public void saveShowAndSchedule(CreateShowRequest createShowRequest, String poster, String qrCode) {
        System.out.println("error1");
        Show show = Show.from(createShowRequest, poster, qrCode);
        System.out.println("error2");
        System.out.println("createShowRequest.getUserId() >> " + createShowRequest.getUserId());
        show.setUser(userRepository.findById(createShowRequest.getUserId()).orElse(null));
        System.out.println("error3");
        showRepository.save(show);
        System.out.println("error4");

        List<CreateScheduleDto> scheduleDtoList = createShowRequest.getSchedule();
        System.out.println("error5");
        System.out.println("scheduleList1 : "+ scheduleDtoList.get(0).getDate());
        List<Schedule> scheduleList = scheduleDtoList.stream().map(Schedule::from).toList();
        System.out.println("error6");
        for (Schedule schedule : scheduleList) {
            schedule.setShow(show);
            System.out.println("error7");
            scheduleRepository.save(schedule);
            System.out.println("error8");
        }

    }
}
