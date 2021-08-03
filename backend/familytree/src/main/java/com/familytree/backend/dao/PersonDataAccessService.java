package com.familytree.backend.dao;
import com.familytree.backend.model.Person;


import java.util.List;
import java.util.Optional;


import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository("mysql")
public class PersonDataAccessService implements PersonDao {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public int insertPerson(String id, Person person) {
		// TODO Auto-generated method stub
		Person temp = new Person(id, person.getPname(), person.getDob(), person.getLob());
		userRepository.save(temp);
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return IterableUtils.toList(userRepository.findAll());
	}

	@Override
	public Optional<Person> selectPersonById(String id) {
		// TODO Auto-generated method stub
		return IterableUtils.toList(userRepository.findAll()).stream()
				.filter(person -> person.getPID().equals(id))
				.findFirst();
	}

	@Override
	public int deletePersonById(String id) {
		// TODO Auto-generated method stub
		Optional<Person> personMaybe = selectPersonById(id);
		if(personMaybe.isEmpty()) {
			return 0;
		}
		//DB.remove(personMaybe.get());
		userRepository.delete(personMaybe.get());
		return 1;
	}

	@Override
	public int updatePersonById(String id, Person update) {
		// TODO Auto-generated method stub
		int flag = deletePersonById(id);
		if(flag == 0) return 0;
		update.setPID(id);
		userRepository.save(update);
		return 1;
	}
	
	

}
