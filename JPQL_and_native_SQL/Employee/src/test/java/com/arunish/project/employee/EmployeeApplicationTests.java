package com.arunish.project.employee;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.arunish.project.employee.entities.Employee;
import com.arunish.project.employee.repos.EmployeeRepository;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	/*@Test
	void contextLoads() {
	}*/
      
	@Test
	public void testStudentCreate()
	{
		Employee emp1=new Employee();
		emp1.setFirstName("Arunish");
		emp1.setLastName("kumar");
		emp1.setAge(21);
		emp1.setSalary(42000d);
		
		Employee emp2=new Employee();
		emp2.setFirstName("Andrew");
		emp2.setLastName("Jose");
		emp2.setAge(26);
		emp2.setSalary(65000d);
		
		repository.save(emp1);
		repository.save(emp2);
	}
	
	@Test
	void findAllEmployees()
	{
       repository.findAllEmployees(PageRequest.of(0, 2)).forEach(emp->System.out.println(emp));
	}
	
	@Test
	void findAllEmployeesPartialData()
	{
       List<Object[]> obj=repository.findAllEmployeePartialData();
       
       for(Object[] ob:obj)
       {
    	   System.out.println(ob[0]);
    	   System.out.println(ob[1]);
       }
	}
	
	@Test
	void findAllEmployeeByFirstName()
	{
		System.out.println(repository.findAllEmployeeByFirstName("Arunish"));
	}
	
	@Test
	void findAllEmployeeWithinSalary()
	{
		System.out.println(repository.findAllEmployeeWithinSalary(40000d,50000d));
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void deleteEmployeeByFirstName()
	{
	  repository.deleteEmployeeByFirstName("Andrew");
	}

	@Test
	void findAllEmployeeGreaterThanAverage()
	{
		repository.findAllEmployeeGreaterThanAverage(Sort.by(new Sort.Order(Direction.ASC,"age"),new Sort.Order(Direction.DESC,"salary"))).forEach(emp->System.out.println(emp));;
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void updateSalary()
	{
		repository.updateSalary(65000d);
	}
	
	
	//@Test
	//@Transactional
	//@Rollback(false)
	//void deleteEmployeeWithMinimumSalary()
	//{
		//repository.deleteEmployeeWithMinimumSalary();
	//}
	
	
	//Native SQL QUESTION 1
	@Test
	void findAllWithLastName()
	{
		List<Object[]> obj=repository.findAllWithLastName();
	       
	       for(Object[] ob:obj)
	       {
	    	System.out.println(ob[0]+" "+ob[1]+" "+ob[2]);
	   
	       }
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void deleteEmployeesGreaterThan()
	{
		repository.deleteEmployeesGreaterThan(45);
	}
	
	
}
