package net.javaguides.springboot.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.FileUpload;
import net.javaguides.springboot.service.EmployeeService;
import net.javaguides.springboot.service.FileUploadService;

@Controller
public class EmployeeController {

	//Display list of Employee
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private EmployeeService employeeService;	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployee());
		return "index";	
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);	
		return "showNewEmployeeForm";	
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/showFromForUpdate/{id}")
	public String showFromForUpdate(@PathVariable (value="id") long id ,Model model) {
		Employee  employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@GetMapping("/deleteEmplyee/{id}")
	public String deleteEmplyee(@PathVariable (value="id") long id ,Model model) {
		this.employeeService.deleteEmployee(id);
		return "redirect:/";
	}
	
	@PostMapping("saveFile")
	public String fileUpload(@RequestParam("data") MultipartFile data,@RequestParam("name") String name) throws IOException {	
		FileUpload fileUpload = new FileUpload();
		fileUpload.setName(name);
		fileUpload.setData(data.getBytes());
		fileUploadService.saveData(fileUpload);
		return "";
		}
	
	@GetMapping("/FileOperations")
	public String fileOperartion()
	{
		return "FileOperations";	
	}
}
