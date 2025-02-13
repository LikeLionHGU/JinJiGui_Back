package org.example.likelion_hackathon.controller.response;

import lombok.*;
import org.example.likelion_hackathon.dto.manager.ManagerShowDto;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerShowListResponse {
    private List<ManagerShowDto> my_show_list;

    public static ManagerShowListResponse from(List<ManagerShowDto> my_show_list){
        return ManagerShowListResponse.builder()
                .my_show_list(my_show_list)
                .build();
    }
}
