package com.codewithmosh.store.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findUserByEmail(String email);

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
