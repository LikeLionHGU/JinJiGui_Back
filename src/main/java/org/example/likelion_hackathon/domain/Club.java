package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

    private String photo;
    private String name;
    private String content;
    private String url1;
    private String url2;
    private String category;
}
