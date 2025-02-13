package org.example.likelion_hackathon.dto.myPage.ReservationList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowDto {
    private String title;
    private String accountNumber;
}