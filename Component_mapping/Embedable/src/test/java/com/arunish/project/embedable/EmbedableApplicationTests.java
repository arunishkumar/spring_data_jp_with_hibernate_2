package com.arunish.project.embedable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arunish.project.embedable.entities.Employee;
import com.arunish.project.embedable.entities.Salary;
import com.arunish.project.embedable.repos.EmployeeRepository;

@SpringBootTest
class EmbedableApplicationTests {

	
	@Autowired
	EmployeeRepository repository;
	@Test
	void contextLoads() {
	}

	
	@Test
	void createData()
	{
		Employee emp=new Employee();
		Salary sal=new Salary();
		emp.setId(1);
		emp.setFirstName("Arunish");
		emp.setLastName("kumar");
		emp.setAge(21);
		sal.setBasicSalary(40000d);
		sal.setBonusSalary(10000d);
		sal.setSpecialAllowanceSalary(5000d);
		sal.setTaxAmount(6000d);
		emp.setSalary(sal);
		
		repository.save(emp);
	}
}
