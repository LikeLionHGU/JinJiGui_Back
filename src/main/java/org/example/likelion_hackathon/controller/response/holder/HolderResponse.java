package org.example.likelion_hackathon.controller.response.holder;

import lombok.*;
import org.example.likelion_hackathon.dto.holder.HolderDto;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderResponse {
    List<HolderDto> reservation_list;

    public static HolderResponse from(List<HolderDto> holderList) {
        return HolderResponse.builder()
                .reservation_list(holderList)
                .build();
    }
}
