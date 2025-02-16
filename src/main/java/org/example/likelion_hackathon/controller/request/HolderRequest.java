package org.example.likelion_hackathon.controller.request;

import lombok.*;
import org.example.likelion_hackathon.dto.holder.ReservationIdDto;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderRequest {
    List<ReservationIdDto> reservation_id_list;
}
