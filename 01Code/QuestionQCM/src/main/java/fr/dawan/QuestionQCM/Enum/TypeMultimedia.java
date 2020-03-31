package fr.dawan.QuestionQCM.Enum;


public enum TypeMultimedia {
image("image"),
audio("audio"),
video("video"),
aucun("aucun");




private String libelle;

private TypeMultimedia(String libelle) {
	this.libelle = libelle;
}

public String getLibelle() {
	return libelle;
}
}

