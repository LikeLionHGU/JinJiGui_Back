package org.example.likelion_hackathon.dto.myPage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.likelion_hackathon.domain.User;

@Getter
@Setter
@Builder
public class MypageDto {
    private String id;
    private int authority;
    private String name;
    private String phoneNumber;
    private int stdCode;

    public static MypageDto from(User user) {
        return MypageDto.builder()
                .id(user.getId())
                .authority(user.getAuthority())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .stdCode(user.getStdCode())
                .build();
    }
}
