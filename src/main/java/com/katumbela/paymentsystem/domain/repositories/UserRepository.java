package com.katumbela.paymentsystem.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.katumbela.paymentsystem.domain.entities.User;

public interface UserRepository extends Repository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAll();

    User save(User user);
}