package com.familytree.backend.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.familytree.backend.model.Person;
import com.familytree.backend.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		//System.out.println("From personController: " + person.getName());
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{pid}")
	public Person getPersonById(@PathVariable("pid")String id) {
		return personService.getPersonById(id).orElse(null);
	}
	
	@DeleteMapping(path = "{pid}")
	public void deletePerson(@PathVariable("pid") String id) {
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "{pid}")
	public void updatePerson(@PathVariable("pid") String id, @Valid @NonNull @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}
}
