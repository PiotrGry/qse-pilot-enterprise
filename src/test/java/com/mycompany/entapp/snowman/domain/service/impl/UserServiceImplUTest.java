/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import com.mycompany.entapp.snowman.domain.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplUTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserServiceImpl();

    @Test
    public void testUserServiceFindUserShouldReturnUserFromRepository() {

        int userId = 9;

        User user = getUser(userId);

        Mockito.when(userRepository.findUser(userId)).thenReturn(user);

        User actualUser = userService.findUser("9");

        assertEquals(user, actualUser);
        Mockito.verify(userRepository, Mockito.times(1)).findUser(userId);
    }

    @Test
    public void testCreateNewUser() {
        User user = getUser(1);

        Mockito.doNothing().when(userRepository).saveUser(user);

        userService.createUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = getUser(1);

        Mockito.doNothing().when(userRepository).saveUser(user);

        userService.updateUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void testDeleteUser(){
        int userId = 1;

        Mockito.doNothing().when(userRepository).removeUser(userId);

        userService.deleteUser(userId);

        Mockito.verify(userRepository, Mockito.times(1)).removeUser(userId);
    }

    private User getUser(int userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("UserName");
        user.setPassword("Password");
        user.setEmail("Email");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        return user;
    }

}
