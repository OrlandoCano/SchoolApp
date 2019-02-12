package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Materia;

public interface MateriasDao extends 
	CrudRepository<Materia, Long>{

}
