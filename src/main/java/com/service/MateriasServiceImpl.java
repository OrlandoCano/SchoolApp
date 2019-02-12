package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MateriasDao;
import com.model.Materia;


@Service
public class MateriasServiceImpl implements MateriasService{

	@Autowired
	private MateriasDao materiasDao;
	
	@Override
	public List<Materia> find() {
		return (List<Materia>) materiasDao.findAll();
	}

	@Override
	public Materia load(Long id) {
//		return materiasDao.findOne(id);
		return materiasDao.findById(id).get();
	}

	@Override
	public Materia persist(Materia materia) {
		
		return materiasDao.save(materia);
	}

	@Override
	public Materia merge(Materia materia) {
		return materiasDao.save(materia);
	}

	@Override
	public Materia delete(Materia materia) {
		 materiasDao.delete(materia);
		 return null;
	}

}
