package com.familytree.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.familytree.backend.model.Person;
import com.familytree.backend.model.Spouses;

@Repository
public interface SpouseRepository extends JpaRepository<Spouses, String>{

}
