/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import com.mycompany.entapp.snowman.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Domain service for User operations.
 * Now uses UserRepository interface instead of directly importing UserDao from infrastructure.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(String userId) {
        return userRepository.findUser(Integer.parseInt(userId));
    }

    @Override
    public void createUser(User user){
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user){
        userRepository.saveUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.removeUser(userId);
    }

}
