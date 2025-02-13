package org.example.likelion_hackathon.controller.response;

import lombok.*;

@Getter
@Setter
@Builder
public class LoginResponse {
    private boolean status;
    private String id;
    private int authority;

    public static LoginResponse from(boolean status, String id, int authority) {
        return LoginResponse.builder().status(status).id(id).authority(authority).build();
    }
}
