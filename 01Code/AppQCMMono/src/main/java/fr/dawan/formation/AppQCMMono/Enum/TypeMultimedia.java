package fr.dawan.formation.AppQCMMono.Enum;


public enum TypeMultimedia {
image("image"),
audio("audio"),
video("video");




private String libelle;

private TypeMultimedia(String libelle) {
	this.libelle = libelle;
}

public String getLibelle() {
	return libelle;
}
}

