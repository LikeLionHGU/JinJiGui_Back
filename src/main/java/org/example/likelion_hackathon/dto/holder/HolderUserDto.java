package org.example.likelion_hackathon.dto.holder;

import lombok.*;
import org.example.likelion_hackathon.domain.User;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HolderUserDto {
    private String name;
    private int stdNumber;
    private String phoneNumber;

    public static HolderUserDto from(User user){
        return HolderUserDto.builder()
                .name(user.getName())
                .stdNumber(user.getStdCode())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
