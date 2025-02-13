package org.example.likelion_hackathon.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.service.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class S3Controller {
    @Value("${cloud.aws.s3.bucket}")
    private String bucket; // S3 버킷 이름

    private final S3Service s3Service;

    // 단일 파일 업로드 처리
    @PostMapping("/image")
    public ResponseEntity<String> updateUserImage(@RequestParam("images") MultipartFile multipartFile) {
        try {
            String uploadUrl = s3Service.uploadFiles(multipartFile, "image/");
            return ResponseEntity.ok(uploadUrl);
        } catch (Exception e) {
            return ResponseEntity.ok("이미지 업로드에 실패했습니다: " + e.getMessage());
        }
    }
}
