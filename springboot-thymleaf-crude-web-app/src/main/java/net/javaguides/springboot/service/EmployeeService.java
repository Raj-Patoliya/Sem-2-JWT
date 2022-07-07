package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployee(long id);
}
