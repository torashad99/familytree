package com.familytree.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familytree.backend.model.Descendants;

@Repository
public interface DescendantRepository extends JpaRepository<Descendants, String>{

}
