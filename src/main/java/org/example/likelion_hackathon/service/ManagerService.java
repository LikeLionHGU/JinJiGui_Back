package org.example.likelion_hackathon.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.dto.manager.ManagerShowDto;
import org.example.likelion_hackathon.repository.ScheduleRepository;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ShowRepository showRepository;
    private final ScheduleRepository scheduleRepository;

    public List<ManagerShowDto> managerShowDtoList(String userId) {
        List<Show> showList = showRepository.findShowByUser_Id(userId);

        return showList.stream().map(ManagerShowDto::from).toList();
    }

    public boolean deleteSelectedShow(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if(schedule == null){
            return false;
        }
        Show show = schedule.getShow();
        showRepository.delete(show);
        return true;
    }
}
