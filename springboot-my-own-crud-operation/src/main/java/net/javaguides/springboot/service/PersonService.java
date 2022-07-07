package net.javaguides.springboot.service;

import java.util.List;
import net.javaguides.springboot.model.Person;


public interface PersonService {
List<Person> getAllPerson();
void savePerson(Person person);
Person getPersonById(long id);
void deletePerson(long id);
}
