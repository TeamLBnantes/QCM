package fr.dawan.formation.AppQCMMono.Models;

public class ObjectFiltresMCQ {

	private String bodyFiltre;
	private String themeFiltre;
	private boolean NonPassedFiltre;
	public String getBodyFiltre() {
		return bodyFiltre;
	}
	public void setBodyFiltre(String bodyFiltre) {
		this.bodyFiltre = bodyFiltre;
	}
	public String getThemeFiltre() {
		return themeFiltre;
	}
	public void setThemeFiltre(String themeFiltre) {
		this.themeFiltre = themeFiltre;
	}

	public boolean isNonPassedFiltre() {
		return NonPassedFiltre;
	}
	public void setNonPassedFiltre(boolean nonPassedFiltre) {
		NonPassedFiltre = nonPassedFiltre;
	}
	public ObjectFiltresMCQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
