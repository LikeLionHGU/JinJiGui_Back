package org.example.likelion_hackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
