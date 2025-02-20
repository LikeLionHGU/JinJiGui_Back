package org.example.likelion_hackathon.controller.response.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.dto.holder.CsvDto;
import org.example.likelion_hackathon.dto.holder.HolderDto;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderResponse {
    private int order;
    private String title;
    List<HolderDto> reservation_list;
    List<CsvDto> csv_json;

    public static HolderResponse from(List<HolderDto> holderList, List<CsvDto> csvList, Schedule schedule) {
        return HolderResponse.builder()
                .order(schedule.getOrder_num())
                .title(schedule.getShow().getTitle())
                .reservation_list(holderList)
                .csv_json(csvList)
                .build();
    }
}
