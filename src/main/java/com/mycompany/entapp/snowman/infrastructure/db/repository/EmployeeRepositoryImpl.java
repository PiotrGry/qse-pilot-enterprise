/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.repository;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.repository.EmployeeRepository;
import com.mycompany.entapp.snowman.infrastructure.db.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Infrastructure implementation of EmployeeRepository.
 * Moved from domain.repository.impl to infrastructure.db.repository
 * to respect the dependency rule: domain must not import infrastructure.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee findEmployee(int employeeId) {
        return employeeDao.retrieveEmployee(employeeId);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    public void removeEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }
}
