package fr.dawan.formation.AppQCMMono.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Enum.Status;
import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.Theme;
import fr.dawan.formation.AppQCMMono.Models.User;

public class TestMcqDao {

	private MCQDAO mcqDao;
	private MCQ mcq;
	private int id;


	@Before
	public void testSaveOrUpdate() {
		mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcq = new MCQ();
		mcq.setBody("questionnaire1");
		mcq.setStatus(Status.disponible);
		mcq.setTheme("java888");
		Assert.assertEquals(0L, mcq.getId());
		mcqDao.saveOrUpdate(mcq);
		Assert.assertNotEquals(0L, mcq.getId());
		id=mcq.getId();
		mcqDao.close();
	}


	@After
	public void testDeleteById() throws Exception {
		mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		mcq = mcqDao.findById(MCQ.class, id);
		Assert.assertNotNull(mcq);
		mcqDao.deleteById(MCQ.class, mcq.getId());
		mcq = mcqDao.findById(MCQ.class, id);
		Assert.assertNull(mcq);
		mcqDao.close();
	}


	@Test
	public void testSearchByTheme() {
		mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs = new ArrayList<>();
		Assert.assertEquals(0, mcqs.size());
		mcqs=mcqDao.searchByTheme("799");
		Assert.assertEquals(0,mcqs.size());
		mcqs=mcqDao.searchByTheme("java888");
		Assert.assertEquals(1,mcqs.size());
		mcqDao.close();
	}

	@Test 
	public void testSearchByStatus() {
		  mcqDao = new MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		  List<MCQ> mcqs = new ArrayList<>();
		  mcqs=mcqDao.searchByStatus(Status.disponible);
		  int size = mcqs.size();
		  Assert.assertEquals(size,mcqs.size());
		  mcq=new MCQ();
		  mcq.setStatus(Status.disponible);
		  mcqDao.saveOrUpdate(mcq);
		  mcqs=mcqDao.searchByStatus(Status.disponible);
		  Assert.assertEquals(size+1,mcqs.size());
		  mcqDao.deleteById(MCQ.class, mcq.getId());
		  mcqDao.close(); 
		}

	@Test
	public void testFindByKWBody() {
		mcqDao = new  MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs = new ArrayList<>();
		int size = mcqs.size();
		mcqs = mcqDao.searchByKWBody("tot");
		Assert.assertEquals(size,mcqs.size());
		mcq=new MCQ();
		mcq.setBody("toto");
		mcqDao.saveOrUpdate(mcq);
		mcqs = mcqDao.searchByKWBody("tot");
		Assert.assertEquals(size+1,mcqs.size());
		mcqDao.deleteById(MCQ.class, mcq.getId());
		mcqDao.close();
	}
	
	
/*	@Test
	public void testSearchByDesigner() {
		mcqDao = new  MCQDAO(Constantes.PERSISTENCE_UNIT_NAME);
		List<MCQ> mcqs = new ArrayList<>();
		
		Assert.assertEquals(1,mcqs.size());
		User user = new User();
		Designer designer = new Designer();
		DesignerDAO designerDAO = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user.setFirstName("greg");
		designer.setUser(user);
		designerDAO.saveOrUpdate(designer);
		mcqs = mcqDao.searchByDesigner(designer);
		Assert.assertEquals(1,mcqs.size());
		designerDAO.close();
		mcqDao.close();
		
	}*/
}
