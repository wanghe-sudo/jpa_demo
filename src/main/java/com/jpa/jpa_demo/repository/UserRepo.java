package com.jpa.jpa_demo.repository;

import com.jpa.jpa_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author
 * @Date 2022/8/19
 * @DESC
 */
public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    User findByUserContractAddress(String userContractAddress);
}
