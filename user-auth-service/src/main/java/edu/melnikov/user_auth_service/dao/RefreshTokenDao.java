package edu.melnikov.user_auth_service.dao;

import edu.melnikov.user_auth_service.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenDao {
    void save(RefreshToken refreshToken);
    Optional<RefreshToken> findByToken(String token);
    void deleteByToken(String token);
    void deleteByUserId(Long userId);
}
