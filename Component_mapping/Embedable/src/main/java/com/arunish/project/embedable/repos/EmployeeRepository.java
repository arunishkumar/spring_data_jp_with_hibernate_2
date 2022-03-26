package com.arunish.project.embedable.repos;

import org.springframework.data.repository.CrudRepository;

import com.arunish.project.embedable.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
