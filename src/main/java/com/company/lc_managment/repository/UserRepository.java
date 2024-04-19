package com.company.lc_managment.repository;

import com.company.lc_managment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByPhoneNumber(String username);

    User findByUsername(String username);
}
