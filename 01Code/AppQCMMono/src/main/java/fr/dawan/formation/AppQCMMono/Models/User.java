package fr.dawan.formation.AppQCMMono.Models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
@Entity
public class User extends Entitie{

	private String lastName;
	private String firstName;
	
	@Column(unique = true)
	private String email;
	
	private String pseudo;
	private String password;
	private LocalDateTime signInDate;
	private LocalDateTime lastConnectionDate;
	@Transient
	private boolean admin;


	@OneToOne (mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)  //car O ou 1 designer
	private Designer designer;
	
	@OneToMany (mappedBy = "user") 
	private Set<MCQpassed> MCQpasseds;

	
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

	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public Set<MCQpassed> getMCQpasseds() {
		return MCQpasseds;
	}
	public void setMCQpasseds(Set<MCQpassed> mCQpasseds) {
		MCQpasseds = mCQpasseds;
	}
	
	
	@Override
	public String toString() {
		return "User [lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", pseudo=" + pseudo
				+ ", password=" + password + ", signInDate=" + signInDate + ", lastConnectionDate=" + lastConnectionDate
				+ ", designer=" + designer + "]";
	}

	public User(String lastName, String firstName, String email, String pseudo, String password, LocalDateTime signInDate,
			LocalDateTime lastConnectionDate, Designer designer) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.pseudo = pseudo;
		this.password = password;
		this.signInDate = signInDate;
		this.lastConnectionDate = lastConnectionDate;
		this.designer = designer;
	}
	public User() {
		super();
	}
	
	



	
	

}
