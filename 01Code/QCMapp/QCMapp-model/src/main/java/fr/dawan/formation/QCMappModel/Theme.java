package fr.dawan.formation.QCMappModel;

import javax.persistence.Entity;

@Entity
public class Theme extends Entitie{

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
