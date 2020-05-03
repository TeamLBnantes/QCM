package fr.dawan.formation.AppQCMMono.Enum;


public enum Status {
//free("libre"),
//validate("validate"),
enConstruction("En construction"),
disponible("disponible");



private String libelle;

private Status(String libelle) {
	this.libelle = libelle;
}

public String getLibelle() {
	return libelle;
}
}

