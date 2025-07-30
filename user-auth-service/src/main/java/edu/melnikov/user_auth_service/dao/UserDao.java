package edu.melnikov.user_auth_service.dao;

import edu.melnikov.user_auth_service.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
    boolean updatePasswordById(Long id, String newPasswordHash);
    Optional<User> getUserInfoById(Long id);
    public boolean updateBalanceById(Long id, double newBalance);
}
