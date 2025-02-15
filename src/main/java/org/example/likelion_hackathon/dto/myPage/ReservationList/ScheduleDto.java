package org.example.likelion_hackathon.dto.myPage.ReservationList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Schedule;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private int order;
    private String date;
    private String time;

    public static ScheduleDto from(Schedule schedule) {
        return ScheduleDto.builder()
                .order(schedule.getOrder_num())
                .date(schedule.getDate().toString())
                .time(schedule.getTime().toString())
                .build();
    }
}

