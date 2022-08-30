package com.jpa.jpa_demo.service;

import com.jpa.jpa_demo.annotition.InsertLog;
import com.jpa.jpa_demo.entity.User;
import com.jpa.jpa_demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Date 2022/8/19
 * @DESC
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> find(User user) {
        return userRepo.findAll();
    }

    public void findByUserContractAddress(String userContractAddress) {
        userRepo.findByUserContractAddress(userContractAddress);
    }

    @InsertLog("testValue")
    public User save(User user) {
        return userRepo.save(user);
    }
}
