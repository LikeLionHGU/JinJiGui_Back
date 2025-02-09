package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_data_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

    private LocalDate postDate;
    private int view;
    private String poster;
    private String content;
    private int maxTickets;
    private int maxPeople;
    private int applyPeople;
    private String account;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private int runtime;
    private String location;
}
