package org.example.likelion_hackathon.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    private String id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    private String name;
    private String phoneNumber;
    private int stdCode;
    private String email;
    private int authority;
}
