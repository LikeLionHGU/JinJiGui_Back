package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.Reservation;
import org.example.likelion_hackathon.domain.Schedule;
import org.example.likelion_hackathon.domain.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CsvDto {
    private String isDeposit;
    private int totalCost;
    private String name;
    private int stdNumber;
    private String phoneNumber;

    public static CsvDto from(Reservation reservation, User user, Schedule schedule, int totalCost){
        return CsvDto.builder()
                .isDeposit(reservation.isDeposit()?"O":"X")
                .name(user.getName())
                .totalCost(totalCost)
                .stdNumber(user.getStdCode())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
