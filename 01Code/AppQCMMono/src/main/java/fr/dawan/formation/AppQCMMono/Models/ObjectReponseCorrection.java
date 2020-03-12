package fr.dawan.formation.AppQCMMono.Models;

public class ObjectReponseCorrection {

	private int idRepCor;
	private boolean repUser;
	private boolean asDesigner;

	public int getIdRepCor() {
		return idRepCor;
	}
	public void setIdRepCor(int idRepCor) {
		this.idRepCor = idRepCor;
	}
	public boolean isRepUser() {
		return repUser;
	}
	public void setRepUser(boolean repUser) {
		this.repUser = repUser;
	}
	
	public boolean isAsDesigner() {
		return asDesigner;
	}
	public void setAsDesigner(boolean asDesigner) {
		this.asDesigner = asDesigner;
	}
	public ObjectReponseCorrection(int id, boolean repUser) {
		super();
		this.idRepCor = id;
		this.repUser = repUser;
	}
	public ObjectReponseCorrection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
