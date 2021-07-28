package com.familytree.backend.dao;

import com.familytree.backend.model.Ancestors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncestorRepository extends JpaRepository<Ancestors, String>{

}
