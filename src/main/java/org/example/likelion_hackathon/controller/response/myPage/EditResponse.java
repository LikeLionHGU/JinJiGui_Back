package org.example.likelion_hackathon.controller.response.myPage;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.likelion_hackathon.domain.User;
@Getter
@Setter
@Builder
public class EditResponse {
    private String id;
    private int authority;
    private String name;
    private String phoneNumber;
    private int stdCode;

    public static EditResponse from(User user) {
        return EditResponse.builder()
                .id(user.getId())
                .authority(user.getAuthority())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .stdCode(user.getStdCode())
                .build();
    }
}
