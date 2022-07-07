package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.Person;
import net.javaguides.springboot.repository.PersonRepository;

@Service
@Transactional 
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	@Override
	public void savePerson(Person person) {
		personRepository.save(person);
	}
	@Override
	public Person getPersonById(long id) {
		Optional<Person> optional = personRepository.findById(id);
		Person person = null;
		if(optional.isPresent())
		{
			person = optional.get();
		}
		else
		{
			throw new RuntimeException("Person not found by id no : "+id);
		}
		return person;
	}
	@Override
	public void deletePerson(long id) {
			personRepository.deleteById(id);
	}
}
