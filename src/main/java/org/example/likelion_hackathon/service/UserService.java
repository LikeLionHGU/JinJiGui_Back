package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean saveOfUpdateUser(String id, String email, String name){
        Optional<User> existingUser = userRepository.findById(id);

        if(existingUser.isPresent()){
            User user = existingUser.get();
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
            return false;
        }else{
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
            return true;
        }
    }

    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no such user"));
    }
}
