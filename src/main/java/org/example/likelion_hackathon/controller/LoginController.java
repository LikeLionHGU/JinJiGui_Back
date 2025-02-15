package org.example.likelion_hackathon.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import jakarta.servlet.http.HttpSession;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import org.example.likelion_hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Value("${google.oauth.client-id}")
    private String clientId;

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/google/session")
    public ResponseEntity<Map<String,Object>> googleLogin(@RequestParam String credential, HttpSession session) {

        System.out.println(credential);
        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(clientId))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(credential);
            if(idToken != null) {
                Payload payload = idToken.getPayload();

                String id = payload.getSubject();
                String email = payload.getEmail();
                String name = (String) payload.get("name");

                userService.saveOfUpdateUser(id, email, name);

                session.setAttribute("id", id);
                session.setAttribute("email", email);
                session.setAttribute("name", name);

                return ResponseEntity.ok(Collections.singletonMap("status", "success"));
            }
            else{
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "invalid"));
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
