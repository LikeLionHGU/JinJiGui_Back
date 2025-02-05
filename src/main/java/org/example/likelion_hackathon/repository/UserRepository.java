package org.example.likelion_hackathon.repository;

import org.example.likelion_hackathon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
