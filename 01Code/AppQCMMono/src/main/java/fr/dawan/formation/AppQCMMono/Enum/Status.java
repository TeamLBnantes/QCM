package fr.dawan.formation.AppQCMMono.Enum;


public enum Status {
free("free"),
validate("validate");


private String libelle;

private Status(String libelle) {
	this.libelle = libelle;
}

public String getLibelle() {
	return libelle;
}
}
