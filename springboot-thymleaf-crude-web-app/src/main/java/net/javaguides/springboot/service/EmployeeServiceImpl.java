package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService	 {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
	}
	@Override	
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional= employeeRepository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee = optional.get();
		}
		else
		{
			throw new RuntimeException("Employee not found from "+id);
		}
		return employee;
	}
	@Override
	public void deleteEmployee(long id) {
		this.employeeRepository.deleteById(id);
	}
}
