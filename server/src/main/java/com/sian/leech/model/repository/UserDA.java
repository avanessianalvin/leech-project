package com.sian.leech.model.repository;

import com.sian.leech.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDA extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
