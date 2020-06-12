package fr.dawan.formation.AppQCMMono.Models;

import javax.persistence.Entity;

import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.GenericDAO;

@Entity
public class AdminTechniqueAppli extends Entitie{   //juste pour voir, je fabrique une classe de type singleton
	
	private String adminPassword;    //ce mot de passe poura servir à donner acces à la modif de ces infos
	private String organisation;
	//info pour l'envoie de mail
	private String mailAdmin;
	private String serveurSmtp;
	private int serveurSmtpPort;
	private String serveurMailCompte;
	private String serveurMailComptePassword;
	private boolean modeSSL;
	private static int count=0;
	private String UrlBaseAppliGestion;
	private String UrlBaseWebApp;

	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		AdminTechniqueAppli.count = count;
	}

	public String getUrlBaseAppliGestion() {
		return UrlBaseAppliGestion;
	}

	public void setUrlBaseAppliGestion(String urlBaseAppliGestion) {
		UrlBaseAppliGestion = urlBaseAppliGestion;
	}

	public String getUrlBaseWebApp() {
		return UrlBaseWebApp;
	}

	public void setUrlBaseWebApp(String urlBaseWebApp) {
		UrlBaseWebApp = urlBaseWebApp;
	}

	public static AdminTechniqueAppli getInstance() {
		return SingletonHolder.instance;
	}
	
	private AdminTechniqueAppli() {
	}
	
	private static final class SingletonHolder {
		  static final AdminTechniqueAppli instance = new AdminTechniqueAppli();   
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
	
	
}
