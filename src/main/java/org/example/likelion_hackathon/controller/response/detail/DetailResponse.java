package org.example.likelion_hackathon.controller.response.detail;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailResponse {
    ShowDetailResponse show;

    public static DetailResponse from(ShowDetailResponse showDetailResponse){
        return DetailResponse.builder().show(showDetailResponse).build();
    }
}
