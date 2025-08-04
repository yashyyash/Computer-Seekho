package com.seekho.api.service;

import com.seekho.api.dto.LoginDto;
import com.seekho.api.entity.User;
import com.seekho.api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public Boolean loginUser(LoginDto loginDto) {
        User user = userRepository.findByStaffUsername(loginDto.getStaff_username());
        if (user == null) {
            return false;
        }

        return user.getStaffPassword().equals(loginDto.getStaff_password());
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
