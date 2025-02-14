package org.example.likelion_hackathon.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import jakarta.servlet.http.HttpSession;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import lombok.RequiredArgsConstructor;
import org.example.likelion_hackathon.controller.response.LoginResponse;
import org.example.likelion_hackathon.domain.User;
import org.example.likelion_hackathon.service.LoginService;
import org.example.likelion_hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoginController {
    @Value("${google.oauth.client-id}")
    private String clientId;

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/api/auth/google/session")
    public ResponseEntity<LoginResponse> googleLogin(@RequestParam String credential, HttpSession session) {
        System.out.println(credential);

        HttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(clientId))
                .build();

        try {
            GoogleIdToken idToken = verifier.verify(credential);
            if (idToken != null) {
                Payload payload = idToken.getPayload();

                String id = payload.getSubject();
                String email = payload.getEmail();
                String name = (String) payload.get("name");

                boolean isNew = userService.saveOfUpdateUser(id, email, name);
                if (isNew) {
                    loginService.makeNewClubAndLinkItToUser(id);
                }
                User user = userService.getUser(id);

                session.setAttribute("id", id);
                session.setAttribute("email", email);
                session.setAttribute("name", name);
                session.setAttribute("authority", user.getAuthority());

                return ResponseEntity.ok().body(LoginResponse.from(true, id, user.getAuthority()));
            } else {
                return ResponseEntity.badRequest().body(LoginResponse.from(false, "-1", -1));
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body(LoginResponse.from(false, "-1", -1));
        }
    }

    @GetMapping("/api/auth/google/logout")
    public ResponseEntity<Map<String, Boolean>> googleLogout(HttpSession session) {
        session.invalidate();

        try {
            String id = (String) session.getAttribute("id");

            return ResponseEntity.status(500).body(Collections.singletonMap("status", false));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Collections.singletonMap("status", true));
        }
    }
}
