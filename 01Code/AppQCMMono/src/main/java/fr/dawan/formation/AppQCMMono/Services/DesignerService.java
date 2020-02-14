package fr.dawan.formation.AppQCMMono.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.DesignerDAO;

public class DesignerService {


    	
		DesignerDAO designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME);
	
	public void saveOrUpdate(Designer d) {
		designerDao.saveOrUpdate(d);
		designerDao.close();
	}
	
	public void saveOrUpdate(Collection<Designer> designers) {
		designerDao.saveOrUpdate(designers);
		designerDao.close();

	}
	
	public void deleteById(int id) {
		designerDao.deleteById(Designer.class, id);
		designerDao.close();

	}

	public Designer findById(int id) {
		Designer designerFound =new Designer();
		designerFound =designerDao.findById(Designer.class, id);
		designerDao.close();

		return designerFound;
	}

	public Set<Designer> findAll() {
		Set<Designer> designersFound =new HashSet<>();
		designersFound =designerDao.findAll(Designer.class);
		designerDao.close();
	return designersFound;
	
}
	public List<Designer> searchByKW(String kw){
		List<Designer> designersFound =new ArrayList<>();
		designersFound = designerDao.searchByKW(kw);
		designerDao.close();
	return designersFound;
		 
	
}
		public List<Designer> searchByDate(LocalDate dateInf, LocalDate dateSup) { 
			List<Designer> designersFound =new ArrayList<>();
			designersFound = designerDao.searchByDate(dateInf, dateSup);
			designerDao.close();
		return designersFound;
	}
	
	
}