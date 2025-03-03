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
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

    private LocalDate postDate;
    private int view;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String poster;

    @Column(nullable = false, columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String content;

    private int maxTickets;
    private String account;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private int runtime;
    private String location;
    private String clubName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String qrCode;

    private String category;

    public static Show from(CreateShowRequest request, String poster, String qrCode) {
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
                .clubName(request.getClubName())
                .category(request.getCategory())
                .qrCode(qrCode)
                .build();
    }
}
