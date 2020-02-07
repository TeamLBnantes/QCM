package fr.dawan.formation.QCMappModel;

import java.util.Date;

public class User extends Entity{

	private String lastName;
	private String firstName;
	private String email;
	private String pseudo;
	private Date signInDate;
	private Date lastConnectionDate;
	private boolean designer;
	
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public Date getSignInDate() {
		return signInDate;
	}
	public void setSignInDate(Date signInDate) {
		this.signInDate = signInDate;
	}
	
	public Date getLastConnectionDate() {
		return lastConnectionDate;
	}
	public void setLastConnectionDate(Date lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}
	public boolean isDesigner() {
		return designer;
	}
	public void setDesigner(boolean designer) {
		this.designer = designer;
	}
}
