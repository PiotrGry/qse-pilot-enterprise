/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.repository;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.repository.UserRepository;
import com.mycompany.entapp.snowman.infrastructure.db.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Infrastructure implementation of UserRepository.
 * Extracts the direct DAO dependency that was previously in UserServiceImpl
 * (domain layer importing infrastructure), moving it to the proper layer.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(int userId) {
        return userDao.findUser(userId);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void removeUser(int userId) {
        userDao.removeUser(userId);
    }
}
