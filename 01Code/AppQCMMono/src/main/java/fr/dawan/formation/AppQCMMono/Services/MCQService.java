package fr.dawan.formation.AppQCMMono.Services;

import java.util.List;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.MCQDAO;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;

public class MCQService {

	public List<MCQ> searchByDesigner(Designer designer) {
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs=mcqDao.searchByDesigner(designer);
		mcqDao.close();
		return mcqs;
	}

	public void create(MCQ mcq) {
		// TODO attention pour le moment, je ne vérifie pas si présence de doublon dans les mcq
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcqDao.saveOrUpdate(mcq);
		mcqDao.close();
	}

	public void deleteById(int id) {
		
		MCQDAO mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcqDao.deleteById(MCQ.class, id);
		mcqDao.close();
	}
	


}
