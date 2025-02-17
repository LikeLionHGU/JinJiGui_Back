package org.example.likelion_hackathon.controller.response.myPage;

import lombok.*;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.dto.myPage.TurnThePage.Update;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveResponse {
    private Update user;

    public static SaveResponse from(User user) {
        Update update = Update.from(user.getName(), user.getPhoneNumber(), user.getStdCode());

        return SaveResponse.builder()
                .user(update)
                .build();
    }
}
