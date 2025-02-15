package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.likelion_hackathon.controller.request.CreateShowRequest;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_data")
public class Show {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

    private LocalDate postDate;
    private int view;
    private String poster;
    private String content;
    private int maxTickets;
    private String account;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private int runtime;
    private String location;

    public static Show from(CreateShowRequest request, String poster) {
        return Show.builder()
                .postDate(LocalDate.now())
                .view(0)
                .poster(poster)
                .content(request.getContent())
                .maxTickets(request.getMaxTickets())
                .account(request.getAccount())
                .title(request.getTitle())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .runtime(request.getRuntime())
                .location(request.getLocation())
                .build();
    }
}
