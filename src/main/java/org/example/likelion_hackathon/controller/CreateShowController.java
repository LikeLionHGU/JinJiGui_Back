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
import org.springframework.web.bind.annotation.*;
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

    // qr 코드 관련된 거 전부 주석처리해서 배포 > 프론트가 되는지 확인.
    @PostMapping(value = "/manager/create/save", consumes = "multipart/form-data")
    public ResponseEntity<Map<String,Object>> createShow(@RequestPart("poster") MultipartFile multipartFile, @RequestPart(value = "qrImage", required = false) MultipartFile qrImage, @RequestPart("request") CreateShowRequest createShowRequest, HttpSession session){
        String uploadUrl = null;
        String qrPicUrl = null;
        try {
            uploadUrl = s3Service.uploadFiles(multipartFile, "show/");
            if(qrImage != null){
                qrPicUrl = s3Service.uploadFiles(qrImage, "qr/");
            }
        } catch (IOException e) {
            return ResponseEntity.ok(Collections.singletonMap("error","이미지 업로드에 실패했습니다: " + e.getMessage()));
        }

        createShowService.saveShowAndSchedule(createShowRequest, uploadUrl, qrPicUrl, session);

        return ResponseEntity.ok().body(Collections.singletonMap("status",true));
    }

}
