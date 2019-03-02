package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class School {

	private String name;
	private Integer codTeacher;
	private Integer codStudent;
	
	
	
	public Integer getCodStudent() {
		return codStudent;
	}
	public void setCodStudent(Integer codStudent) {
		this.codStudent = codStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCodTeacher() {
		return codTeacher;
	}
	public void setCodTeacher(Integer codTeacher) {
		this.codTeacher = codTeacher;
	}
	
}
