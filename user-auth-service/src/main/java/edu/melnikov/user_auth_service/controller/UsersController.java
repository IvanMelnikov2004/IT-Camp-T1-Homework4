package edu.melnikov.user_auth_service.controller;

import edu.melnikov.user_auth_service.dto.NewPasswordRequestDto;
import edu.melnikov.user_auth_service.entity.User;
import edu.melnikov.user_auth_service.service.JwtService;
import edu.melnikov.user_auth_service.service.UserService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UsersController {
    private final UserService userService;
    private final JwtService jwtService;

    public UsersController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PutMapping("/change-password")
    @RateLimiter(name = "defaultLimiter")
    public ResponseEntity<?> changePassword(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody @Valid NewPasswordRequestDto newPasswordRequestDto) {

        String token = authHeader.substring(7); // Убираем "Bearer "
        Claims claims = jwtService.extractClaims(token);

        return userService.changePassword(claims.get("id", Long.class), newPasswordRequestDto);

    }

    @GetMapping("/info")

    public ResponseEntity<User> getCurrentUserInfo(
            @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);
        Claims claims = jwtService.extractClaims(token);

        User user = userService.getUserInfo(claims.get("id", Long.class));
        user.setPasswordHash("");

        return ResponseEntity.ok(user);
    }


}
