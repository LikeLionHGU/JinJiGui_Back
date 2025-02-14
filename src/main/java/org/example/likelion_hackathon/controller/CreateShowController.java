package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.CreateShowRequest;
import org.example.likelion_hackathon.dto.createShow.CreateScheduleDto;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.service.CreateShowService;
import org.example.likelion_hackathon.service.S3Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CreateShowController {
    private final CreateShowService createShowService;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket; // S3 버킷 이름

    private final S3Service s3Service;

    @PostMapping("/manager/create/save")
    public ResponseEntity<Map<String,Object>> createShow(@RequestParam("poster") MultipartFile multipartFile, @RequestBody CreateShowRequest createShowRequest, HttpSession session){
        String uploadUrl;
        try {
            uploadUrl = s3Service.uploadFiles(multipartFile, "show/");
        } catch (IOException e) {
            return ResponseEntity.ok(Collections.singletonMap("error","이미지 업로드에 실패했습니다: " + e.getMessage()));
        }

        createShowService.saveShowAndSchedule(createShowRequest, uploadUrl, session);

        return ResponseEntity.ok().body(Collections.singletonMap("status",true));
    }

}
