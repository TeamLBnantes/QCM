package fr.dawan.formation.AppQCMMono.Models;

public class ObjectReponseCorrection {

	private int idRepCor;
	private boolean repUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isRepUser() {
		return repUser;
	}
	public void setRepUser(boolean repUser) {
		this.repUser = repUser;
	}
	public ObjectReponseCorrection(int id, boolean repUser) {
		super();
		this.id = id;
		this.repUser = repUser;
	}
	public ObjectReponseCorrection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
