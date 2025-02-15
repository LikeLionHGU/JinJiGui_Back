package org.example.likelion_hackathon.dto.showDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.likelion_hackathon.domain.Club;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubDetailDto {
    private String photo;
    private String name;
    private String category;
    private String content;
    private String url1;
    private String url2;

    public static ClubDetailDto from(Club club) {
        return ClubDetailDto.builder()
                .photo(club.getPhoto())
                .name(club.getName())
                .category(club.getCategory())
                .content(club.getContent())
                .url1(club.getUrl1())
                .url2(club.getUrl2())
                .build();
    }
}
