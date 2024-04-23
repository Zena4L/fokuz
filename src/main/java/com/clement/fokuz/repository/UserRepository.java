package com.clement.fokuz.repository;

import com.clement.fokuz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM User u WHERE u.userName = :username")
    Optional<User> findUserByUserName(String username);
}
