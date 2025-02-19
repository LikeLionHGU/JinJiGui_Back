package org.example.likelion_hackathon.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.request.ReservationRequest;
import org.example.likelion_hackathon.controller.response.ReservationResponse;
import org.example.likelion_hackathon.controller.response.detail.DetailResponse;
import org.example.likelion_hackathon.controller.response.detail.ShowDetailResponse;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.example.likelion_hackathon.service.ShowDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShowDetailController {
    private final ShowDetailService showDetailService;
    private final ShowRepository showRepository;

    @GetMapping("/show/{id}")
    public ResponseEntity<DetailResponse> getShowDetail(@PathVariable Long id, HttpSession session) {
        boolean isExist = showDetailService.countUpView(id);
        ShowDetailResponse showDetailResponse = null;
        if(isExist){
            Show show = showDetailService.getShowById(id);
            showDetailResponse = ShowDetailResponse.from(show, showDetailService.getScheduleDetailDetailDtoList(show, session));
        } else{
            Show show = new Show();
            show.setId((long)-1);
            showDetailResponse = ShowDetailResponse.from(show, null);
        }
        DetailResponse detailResponse = DetailResponse.from(showDetailResponse);
        return ResponseEntity.ok().body(detailResponse);
    }

    // 이거 확인 필요
    @PostMapping("/show/reservation")
    public ResponseEntity<ReservationResponse> reservation(@RequestBody ReservationRequest reservationRequest, HttpSession session) {
        System.out.println("<<ok>>");
        ReservationResponse reservationResponse = showDetailService.returnReservationResponse(reservationRequest);
        return ResponseEntity.ok().body(reservationResponse);
    }
}
