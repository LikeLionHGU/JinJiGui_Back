package org.example.likelion_hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.example.likelion_hackathon.domain")
public class LikeLionHackathonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LikeLionHackathonApplication.class, args);
    }

}
