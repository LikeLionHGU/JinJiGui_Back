package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Schedule;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderScheduleDto {
    private int order;

    public static HolderScheduleDto from(Schedule schedule) {
        return HolderScheduleDto.builder()
                .order(schedule.getOrder_num())
                .build();
    }
}
