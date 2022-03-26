package com.arunish.project.employee.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.arunish.project.employee.entities.Employee;




public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("from Employee") //here using Employee Entity created here(not database one)
	List<Employee> findAllEmployees(Pageable pageable);
	
	@Query("select emp.firstName,emp.lastName from Employee emp")
	List<Object[]> findAllEmployeePartialData();
	
	@Query("from Employee where firstName=:firstName")
	List<Employee> findAllEmployeeByFirstName(@Param("firstName") String firstName);
	
	@Query("from Employee where salary>:min and salary<:max")
	List<Employee> findAllEmployeeWithinSalary(@Param("min") double min,@Param("max") double max);
	
	@Modifying
	@Query("delete from Employee where firstName=:firstName")
	void deleteEmployeeByFirstName(@Param("firstName") String firstName);
	
	//JPQL Question 1
	@Query("select emp from Employee emp where salary>(select avg(emp.salary) from emp)")
	List<Employee> findAllEmployeeGreaterThanAverage(Sort sort);
	
	//JPQL Question 2
	@Modifying
	@Query("update Employee as emp set emp.salary= :newsalary")
	void updateSalary(@Param("newsalary") double newsalary);
	
	//@Modifying
	//@Query("delete")
	//void deleteEmployeeWithMinimumSalary();
	
	//Native SQL QUESTION 1
	@Query(value="select empId,empFirstName,empAge from employee where empLastName ='singh'",nativeQuery=true)
	List<Object[]> findAllWithLastName();
	
	//Native SQL QUESTION 2
	@Modifying
	@Query(value="delete from employee where empAge>:age",nativeQuery=true)
	void deleteEmployeesGreaterThan(@Param("age") int age);

}
