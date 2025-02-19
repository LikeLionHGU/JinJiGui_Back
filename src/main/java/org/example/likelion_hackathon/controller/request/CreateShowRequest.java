package org.example.likelion_hackathon.controller.request;

import lombok.*;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;

import java.time.LocalDate;
import java.util.List;

@Getter
public class CreateShowRequest {
    private String title;
    private String location;
    private String clubName;
    private LocalDate startDate;
    private LocalDate endDate;
    private int runtime;
    private String account;
    private String content;
    private int maxTickets;
    private String userId;
    private String category;
//    private CreateScheduleDto firstSchedule;
    private List<CreateScheduleDto> schedule;
}
