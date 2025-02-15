package org.example.likelion_hackathon.dto.myPage.ReservationList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.Show;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private int order;
    private String date;
    private String time;

    public static ScheduleDto from(Schedule schedule) {
        return new ScheduleDto(schedule.getOrder_num(), schedule.getDate().toString(), schedule.getTime().toString());
    }

}