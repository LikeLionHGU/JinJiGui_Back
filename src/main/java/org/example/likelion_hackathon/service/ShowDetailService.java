package org.example.likelion_hackathon.service;

import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.domain.Show;
import org.example.likelion_hackathon.repository.ShowRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowDetailService {
    private final ShowRepository showRepository;

    public Show getShowById(Long id) {
        return showRepository.findById(id).orElse(null);
    }
}
