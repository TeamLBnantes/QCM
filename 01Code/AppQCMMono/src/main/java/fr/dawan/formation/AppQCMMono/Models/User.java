package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
@Entity
public class User extends Entitie{

	private String lastName;
	private String firstName;
	private String email;
	private String pseudo;
	private LocalDateTime signInDate;
	private LocalDateTime lastConnectionDate;
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
	public LocalDateTime getSignInDate() {
		return signInDate;
	}
	public void setSignInDate(LocalDateTime signInDate) {
		this.signInDate = signInDate;
	}
	public LocalDateTime getLastConnectionDate() {
		return lastConnectionDate;
	}
	public void setLastConnectionDate(LocalDateTime lastConnectionDate) {
		this.lastConnectionDate = lastConnectionDate;
	}
	public boolean isDesigner() {
		return designer;
	}
	public void setDesigner(boolean designer) {
		this.designer = designer;
	}

	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", pseudo=" + pseudo
				+ ", signInDate=" + signInDate + ", lastConnectionDate=" + lastConnectionDate + ", designer=" + designer
				+ "]";
	}
	public User(String lastName, String firstName, String email, String pseudo, LocalDateTime signInDate,
			LocalDateTime lastConnectionDate, boolean designer) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.pseudo = pseudo;
		this.signInDate = signInDate;
		this.lastConnectionDate = lastConnectionDate;
		this.designer = designer;
	}
	public User() {
		super();
	}
	
	



	
	

}
