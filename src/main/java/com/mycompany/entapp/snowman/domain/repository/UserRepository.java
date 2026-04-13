/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.User;

/**
 * Domain repository interface for User persistence.
 * Implementation resides in the infrastructure layer.
 */
public interface UserRepository {
    User findUser(int userId);
    void saveUser(User user);
    void removeUser(int userId);
}
