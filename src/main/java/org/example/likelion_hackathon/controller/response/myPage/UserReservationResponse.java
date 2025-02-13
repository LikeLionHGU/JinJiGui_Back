package org.example.likelion_hackathon.controller.response.myPage;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.dto.myPage.ReservationList.UserReservationDto;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserReservationResponse {
    List<UserReservationDto> user_reservation_list;

    public static UserReservationResponse from(List<UserReservationDto> user_reservation_list) {
        return UserReservationResponse.builder()
                .user_reservation_list(user_reservation_list).build();
    }
}
