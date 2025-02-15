package org.example.likelion_hackathon.dto.showDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDetailDto {
    private Long id;
    private int order;
    private LocalDate date;
    private LocalTime time;
    private int cost;

    public static ScheduleDetailDto from(Schedule schedule) {
        return ScheduleDetailDto.builder()
                .id(schedule.getId())
                .order(schedule.getOrder_num())
                .date(schedule.getDate())
                .time(schedule.getTime())
                .cost(schedule.getCost())
                .build();
    }
}
