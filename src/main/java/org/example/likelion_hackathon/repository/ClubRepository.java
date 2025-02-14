package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findClubByUser(User user);

    Club findClubByUser_Id(String userId);
}
