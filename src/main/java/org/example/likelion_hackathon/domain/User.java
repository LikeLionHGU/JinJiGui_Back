package org.example.likelion_hackathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private int stdCode;
    private String email;
    private boolean authority;
}
