package com.jpa.jpa_demo;

import com.jpa.jpa_demo.entity.User;
import com.jpa.jpa_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() {
        User build = User.builder().userContractAddress("0xB4EdDBEC54014f45093376DDb9f4F805B26efc80").referContractAddress("456").build();
        User add = userService.save(build);
        System.out.println(add);
    }

    @Test
    public void findAllUser() {
        List<User> users = userService.find(User.builder().build());
        System.out.println(users);
    }

    @Test
    public void findByUserContractAddress() {
        userService.findByUserContractAddress("123");
    }

}
