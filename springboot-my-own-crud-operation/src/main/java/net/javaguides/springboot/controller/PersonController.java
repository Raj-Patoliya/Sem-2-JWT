package net.javaguides.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.model.FileHandling;
import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService personService;
	@GetMapping("/")
	public String viewHome(Model model) {
		model.addAttribute("personList",personService.getAllPerson());
		return "index";
	}
	@GetMapping("/addNewPerson")
	public String addNewPerson(Model model)
	{
		Person person = new Person();
		model.addAttribute("person", person);
		return "addNewPerson";
	}
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Person person ) {
		personService.savePerson(person);
		return "redirect:/";
	}
	@GetMapping("/editPerson/{id}")
	public String editPerson(@PathVariable (value="id") long id,Model model)
	{
		Person person = personService.getPersonById(id);
		model.addAttribute("personData", person);
		return "update_person";
	}
	@GetMapping("/deletePerson/{id}")
	public String deletePerson(@PathVariable (value = "id") long id)	
	{
		personService.deletePerson(id);
		return "redirect:/";
	}
	@GetMapping("fileOperartion")
	public String fileOperartion() {
		return"FileOperations";
	}
	
	@RequestMapping("/saveFile")
	public String fileUpload(@ModelAttribute("assignment") FileHandling fileHandling,@RequestParam("fileName") MultipartFile filess) throws IOException {
		System.out.println(fileHandling.getName());
		System.out.println(filess.getOriginalFilename().toString());
		try {			
			String upload_dir = "C:\\Users\\Lapcare\\eclipse-workspace\\springboot-oneOneza-1\\src\\main\\resources\\static\\assets\\Assignments";
			Files.copy(filess.getInputStream(), Path.of(upload_dir+File.separator+filess.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "index";		
	}
	
	
}
