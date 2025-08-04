package com.seekho.api.repository;


import com.seekho.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByStaffUsername(String staffUsername);
}
