package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Materia;
import com.service.MateriasService;


@RestController
@RequestMapping("/api/")
public class MateriasController {
	
	@Autowired
	private MateriasService service;
	
	@RequestMapping(value = "/materias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody List<Materia> getMaterias(HttpServletResponse httpResponse) throws IOException{
		List<Materia> materias = null;
		try{
			materias = service.find();
			return materias;
		}catch(Exception e){
			httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	@RequestMapping(value = "/materias", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody Materia saveMaterias(@RequestBody Materia materia, HttpServletResponse httpResponse) throws IOException{
		try{
			if(materia.getId() != null){
				materia = service.merge(materia);
			}else{
				materia = service.persist(materia);
			}
			return materia;
		}catch(Exception e){
			httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	@RequestMapping(value = "/materias/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody Materia removeMateria(@PathVariable Long id, HttpServletResponse httpResponse) throws IOException{
		Materia materia = null;
		try{
			materia = service.load(id);
			materia = service.delete(materia);
			return materia;
		}catch(Exception e){
			httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	@RequestMapping(value = "/materias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody Materia loadMateria(@PathVariable Long id, HttpServletResponse httpResponse) throws IOException{
		Materia materia = null;
		try{
			materia = service.load(id);
			return materia;
		}catch(Exception e){
			httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
