package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Materia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5415155355870604685L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "subject_name")
	private String subjectName;
	@Column(name = "semester")
	private int semester;

	
	public Materia() {
		super();
	}
	public Materia(Long id, String subjectName, int semester) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.semester = semester;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
}
