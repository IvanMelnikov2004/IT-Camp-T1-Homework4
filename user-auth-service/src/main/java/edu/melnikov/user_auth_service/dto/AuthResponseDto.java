package edu.melnikov.user_auth_service.dto;

public record AuthResponseDto(String accessToken, String refreshToken) {}