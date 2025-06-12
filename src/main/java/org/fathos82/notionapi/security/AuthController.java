package org.fathos82.notionapi.security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;
    @PostMapping("login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest request) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(request.cpf(), request.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        String token = jwtService.generateToken(request.cpf());

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .body("Token atualizado");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();


    }
}
