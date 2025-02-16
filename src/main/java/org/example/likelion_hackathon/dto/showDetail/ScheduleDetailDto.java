package org.example.likelion_hackathon.dto.showDetail;

import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.example.likelion_hackathon.domain.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDetailDto {
    private Long id;
    private int order;
    private LocalDate date;
    private LocalTime time;
    private int cost;
    private int maxPeople;
    private int applyPeople;
    private boolean canReservation;

    public static ScheduleDetailDto from(Schedule schedule) {
        return ScheduleDetailDto.builder()
                .id(schedule.getId())
                .order(schedule.getOrder_num())
                .date(schedule.getDate())
                .time(schedule.getTime())
                .cost(schedule.getCost())
                .maxPeople(schedule.getMaxPeople())
                .applyPeople(schedule.getApplyPeople())
                .build();
    }
}
