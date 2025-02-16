package org.example.likelion_hackathon.dto.manager;

import lombok.*;
import org.example.likelion_hackathon.domain.Schedule;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerScheduleDto {
    private Long scheduleId;
    private int maxPeople;
    private int applyPeople;

    public static ManagerScheduleDto from(Schedule schedule) {
        return ManagerScheduleDto.builder()
                .scheduleId(schedule.getId())
                .maxPeople(schedule.getMaxPeople())
                .applyPeople(schedule.getApplyPeople())
                .build();
    }
}
