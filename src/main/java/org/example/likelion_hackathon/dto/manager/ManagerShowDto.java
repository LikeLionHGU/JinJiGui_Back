package org.example.likelion_hackathon.dto.manager;

import lombok.*;
import org.example.likelion_hackathon.domain.Show;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerShowDto {
    private Long id;
    private String title;
    List<ManagerScheduleDto> schedule;

    public static ManagerShowDto from(Show show) {
        return ManagerShowDto.builder()
                .id(show.getId())
                .title(show.getTitle())
                .schedule(show.getScheduleList().stream().map(ManagerScheduleDto::from).toList())
                .build();
    }
}
