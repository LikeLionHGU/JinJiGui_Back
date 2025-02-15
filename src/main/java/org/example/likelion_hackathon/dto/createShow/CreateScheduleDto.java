package org.example.likelion_hackathon.dto.createShow;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class CreateScheduleDto {
    private int order;
    private LocalDate date;
    private LocalTime time;
    private int cost;
    private int maxPeople;
}
