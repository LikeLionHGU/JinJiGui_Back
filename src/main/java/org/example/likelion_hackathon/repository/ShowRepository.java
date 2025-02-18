package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findShowByUser_Id(String userId);
}
