package fr.dawan.formation.QCMappModel;

import java.util.Date;

public class Designer{
private int id;
private String presentation;
private Date dateStatus;
private String expertiseField;
private boolean certifier;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPresentation() {
	return presentation;
}
public void setPresentation(String presentation) {
	this.presentation = presentation;
}
public Date getDateStatus() {
	return dateStatus;
}
public void setDateStatus(Date dateStatus) {
	this.dateStatus = dateStatus;
}
public String getExpertiseField() {
	return expertiseField;
}
public void setExpertiseField(String expertiseField) {
	this.expertiseField = expertiseField;
}
public boolean isCertifier() {
	return certifier;
}
public void setCertifier(boolean certifier) {
	this.certifier = certifier;
}
public Designer(int id, String presentation, Date dateStatus, String expertiseField, boolean certifier) {
	super();
	this.id = id;
	this.presentation = presentation;
	this.dateStatus = dateStatus;
	this.expertiseField = expertiseField;
	this.certifier = certifier;
}
public Designer() {
	super();
}
@Override
public String toString() {
	return "Designer [id=" + id + ", presentation=" + presentation + ", dateStatus=" + dateStatus + ", expertiseField="
			+ expertiseField + ", certifier=" + certifier + "]";
}



}
