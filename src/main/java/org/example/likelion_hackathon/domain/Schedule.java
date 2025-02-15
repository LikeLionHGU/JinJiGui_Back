package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    private int order_num;
    private LocalDate date;
    private LocalTime time;
    private int cost;
    private int maxPeople;
    private int applyPeople;

    public static Schedule from(CreateScheduleDto createScheduleDto) {
        return Schedule.builder()
                .order_num(createScheduleDto.getOrder())
                .date(createScheduleDto.getDate())
                .time(createScheduleDto.getTime())
                .cost(createScheduleDto.getCost())
                .maxPeople(createScheduleDto.getMaxPeople())
                .applyPeople(0)
                .build();
    }
}
