package org.example.likelion_hackathon.controller.response.myPage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.myPage.TurnThePage.Update;

@Getter
@Setter
@Builder
public class UpdateResponse {
//    private String id;
//    private int authority;


    private Update user;

    public static UpdateResponse from(User user) {
        return UpdateResponse.builder()
                .user(Update.from(
                        user.getName(),
                        user.getPhoneNumber(),
                        user.getStdCode()
                ))
                .build();


    }
}
