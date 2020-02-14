package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.time.LocalDate;
import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Designer;



public interface DAODesignerInterface {


	public List<Designer> searchByCertifier (boolean Certifier);
	public List<Designer> searchByKW (String kw);
	public List<Designer> searchByDate (LocalDate date1, LocalDate date2);

}
