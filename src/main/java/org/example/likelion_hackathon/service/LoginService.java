package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.domain.Club;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.repository.ClubRepository;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final ClubRepository clubRepository;

    public void makeNewClubAndLinkItToUser(String id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user"));
        Club newClub = new Club();

        newClub.setUser(user);
        clubRepository.save(newClub);

        Club club = clubRepository.findClubByUser(user);
        user.setClub(club);
        userRepository.save(user);

        System.out.println("<<ok>>");
    }

}
