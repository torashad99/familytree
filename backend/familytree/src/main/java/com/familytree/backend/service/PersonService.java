package com.familytree.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.familytree.backend.dao.PersonDao;
import com.familytree.backend.model.Person;

@Service
public class PersonService {

	private final PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("mysql")PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(Person person) {
		//System.out.println("From personService: " + person.getName());
		return personDao.insertPerson(person);
		
	}
	
	public List<Person> getAllPeople() {
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(String id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(String id) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(String id, Person newPerson) {
		return personDao.updatePersonById(id, newPerson);
	}
}
