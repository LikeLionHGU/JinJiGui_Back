package org.example.likelion_hackathon.dto.myPage.ReservationList;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Reservation;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserReservationDto {
    private ShowDto show;
    private ScheduleDto schedule;
    private ReservationDto reservation;
    private int totalCost;

    public static UserReservationDto from(Reservation reservation) {
        return UserReservationDto.builder()
                .show(ShowDto.from(reservation.getShow()))  // ✅ 올바른 변환 메서드 사용
                .schedule(ScheduleDto.from(reservation.getSchedule())) // ✅ 추가 변환 적용
                .reservation(ReservationDto.from(reservation)) // ✅ 추가 변환 적용
                .totalCost(reservation.getSchedule().getCost()) // ✅ 총 비용 추가
                .build();
    }
}
