package fr.dawan.formation.AppQCMMono.Persistence.Interfaces;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.Question;


public interface DAOQuestionInterface {



	public List<Question> searchByTheme (String theme);
	public List<Question> searchByStatus (Status status);
	public List<Question> searchByKWBody (String kw);

	public List<Question> searchByDesigner (Designer designer);
}
