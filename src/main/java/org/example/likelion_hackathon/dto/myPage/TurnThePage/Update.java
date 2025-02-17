package org.example.likelion_hackathon.dto.myPage.TurnThePage;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Update {

    private String userName;
    private String phoneNumber;
    private int stdCode;

    public static Update from(String userName, String phoneNumber, int stdCode) {
        return builder()
                .userName(userName)
                .phoneNumber(phoneNumber)
                .stdCode(stdCode)
                .build();
    }
}
