package fr.dawan.formation.QCMappModel;

import java.util.Date;

public class User {
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String pseudo;
	private Date signInDate;
	private Date lastConnectionDate;
	private boolean designer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public User(int id, String lastName, String firstName, String email, String pseudo, Date signInDate, Date lastConnectionDate,boolean designer) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.pseudo = pseudo;
		this.signInDate = signInDate;
		this.lastConnectionDate = lastConnectionDate;
		this.designer = designer;
	
	}
	public User(int id, String lastName, String firstName, String email, String pseudo,  boolean designer) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.pseudo = pseudo;
		
		this.designer = designer;
	
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", pseudo=" + pseudo + ", signInDate=" + signInDate + ", designer=" + designer + "]";
	}

	
	
}
