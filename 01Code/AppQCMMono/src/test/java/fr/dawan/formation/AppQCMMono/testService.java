package fr.dawan.formation.AppQCMMono;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.DesignerDAO;
import fr.dawan.formation.AppQCMMono.Services.DesignerService;

public class testService {
	
	 Designer dsn1 = new Designer();
	Designer dsn2 = new Designer();
	Designer dsn3 = new Designer();
	
	 Question qst1 = new Question();
	 Question qst2 = new Question();
	 Set<Question> questions = new HashSet<>();
	Set<Designer> designers = new HashSet<>();
	 int id;
	 int id2 = 120;
	String kw = "2";
	
	@Test
	public void DesignerInsert() {
	qst1.setBody("bodyQ1");
	qst1.setCommentPostAnswer("commentPostAnswerQ1");
	qst1.setHelp("helpQ1");
	questions.add(qst1);
	
	
	qst2.setBody("bodyQ2");
	qst2.setCommentPostAnswer("commentPostAnswerQ2");
	qst2.setHelp("helpQ2");
	questions.add(qst2);
	
		dsn1.setExpertiseField("expertiseField");
		dsn1.setPresentation("presentation");
		dsn1.setQuestions(questions);
		
		DesignerService dsnSvc = new DesignerService();
		dsnSvc.saveOrUpdate(dsn1);
		
		 id = dsn1.getId();
		assertNotNull(id);
	}
	
	@Test
	public void DesignerGroupInsert() {
		dsn2.setExpertiseField("expertiseField2");
		dsn2.setPresentation("presentation2");
		dsn2.setQuestions(questions);
		designers.add(dsn2);
		
		dsn3.setExpertiseField("expertiseField3");
		dsn3.setPresentation("presentation3");
		dsn3.setQuestions(questions);
		designers.add(dsn3);
		
		DesignerService dsnSvc2 = new DesignerService();
		dsnSvc2.saveOrUpdate(designers);
		int id2 = dsn2.getId();
		assertNotNull(id2);
		int id3 = dsn3.getId();
		assertNotNull(id3);
		
	}
	
	@Test
	public void findAllDesigner() {
		DesignerService dsnSvc3 = new DesignerService();
		Set<Designer>designersFound= new HashSet<>();
		designersFound = dsnSvc3.findAll();

		assertTrue((designersFound).containsAll(designers));
		System.out.println("findAllDesigners"+designersFound.size());

	}
	
	@Test
	public void findByKW() {
		DesignerService dsnSvc4 = new DesignerService();
		List<Designer>designersFound1= new ArrayList<>();
		designersFound1 = dsnSvc4.searchByKW(kw);

		assertNotEquals(0, (designersFound1).size());
		System.out.println("findByKw"+designersFound1.size());
	}

	
	@Test
	public void findById() {
		
		DesignerService dsnSvc6 = new DesignerService();
		Designer designerFound3 = new Designer();
		//designerFound3 = dsnSvc6.findById(id2);
		designerFound3 = dsnSvc6.findById(2);
		System.out.println("FindById"+designerFound3);

		assertNotEquals(0, designerFound3.getId());
		assertEquals("expertiseField", designerFound3.getExpertiseField());
		
	}
	@Test
	public void findByIdDAO() {
		
		DesignerDAO dDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		Designer designerFound5 = new Designer();
		designerFound5 = dDao.findById(Designer.class, id2);

		assertEquals(designerFound5.getId(), dsn1.getId());
		assertEquals(designerFound5.getExpertiseField(), dsn1.getExpertiseField());
		assertEquals(designerFound5.getPresentation(), dsn1.getPresentation());
	}
	
	
	@Test
	public void deleteDesigner() {
		DesignerService dsnSvc7 = new DesignerService();
		dsnSvc7.deleteById(id);
		Designer designerFound4 = new Designer();
		DesignerService dsnSvc8 = new DesignerService();

		designerFound4 = dsnSvc8.findById(id);
		assertNull(designerFound4);
	}
}
