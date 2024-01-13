package com.artemnizhnyk.securitytestapp.repository;

import com.artemnizhnyk.securitytestapp.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String username);
}
