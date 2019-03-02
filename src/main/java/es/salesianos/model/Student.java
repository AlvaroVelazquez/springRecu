package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int Cod;
	
	
	public int getCod() {
		return Cod;
	}
	public void setCod(int cod) {
		this.Cod = cod;
	}
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
