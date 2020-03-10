package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Theme;


public interface DAOMCQInterface {



	public List<MCQ> searchByTheme (String theme);
	public List<MCQ> searchByStatus (Status status);
	public List<MCQ> searchByKWBody (String kw);
	public List<MCQ> searchByDesigner (Designer designer);
}
