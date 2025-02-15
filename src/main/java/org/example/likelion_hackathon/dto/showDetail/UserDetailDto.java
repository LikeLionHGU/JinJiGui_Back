package org.example.likelion_hackathon.dto.showDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.User;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
    private String name;
    private String phoneNumber;

    public static UserDetailDto from(User user) {
        return UserDetailDto.builder()
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
