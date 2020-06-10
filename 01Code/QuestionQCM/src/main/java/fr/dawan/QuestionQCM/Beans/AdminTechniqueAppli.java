package fr.dawan.QuestionQCM.Beans;

import javax.persistence.Entity;

@Entity
public class AdminTechniqueAppli  extends Entitie {

	private String adminPassword;    //ce mot de passe poura servir à donner acces à la modif de ces infos
	private String organisation;
	//info pour l'envoie de mail
	private String mailAdmin;
	private String serveurSmtp;
	private int serveurSmtpPort;
	private String serveurMailCompte;
	private String serveurMailComptePassword;
	private boolean modeSSL;

	

	public AdminTechniqueAppli() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getMailAdmin() {
		return mailAdmin;
	}
	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}
	public String getServeurSmtp() {
		return serveurSmtp;
	}
	public void setServeurSmtp(String serveurSmtp) {
		this.serveurSmtp = serveurSmtp;
	}
	public int getServeurSmtpPort() {
		return serveurSmtpPort;
	}
	public void setServeurSmtpPort(int serveurSmtpPort) {
		this.serveurSmtpPort = serveurSmtpPort;
	}
	public String getServeurMailCompte() {
		return serveurMailCompte;
	}
	public void setServeurMailCompte(String serveurMailCompte) {
		this.serveurMailCompte = serveurMailCompte;
	}
	public String getServeurMailComptePassword() {
		return serveurMailComptePassword;
	}
	public void setServeurMailComptePassword(String serveurMailComptePassword) {
		this.serveurMailComptePassword = serveurMailComptePassword;
	}
	public boolean isModeSSL() {
		return modeSSL;
	}
	public void setModeSSL(boolean modeSSL) {
		this.modeSSL = modeSSL;
	}
	
	@Override
	public String toString() {
		return "AdminTechnique [adminPassword=" + adminPassword + ", organisation=" + organisation + ", mailAdmin="
				+ mailAdmin + ", serveurSmtp=" + serveurSmtp + ", serveurSmtpPort=" + serveurSmtpPort
				+ ", serveurMailCompte=" + serveurMailCompte + ", serveurMailComptePassword="
				+ serveurMailComptePassword + ", modeSSL=" + modeSSL + "]";
	}
	
}
