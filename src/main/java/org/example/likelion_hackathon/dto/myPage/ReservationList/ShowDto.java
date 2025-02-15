package org.example.likelion_hackathon.dto.myPage.ReservationList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Show;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private String title;
    private String accountNumber;

    public static ShowDto from(Show show) {
        return ShowDto.builder()
                .title(show.getTitle())
                .accountNumber(show.getAccount())
                .build();
    }
}

