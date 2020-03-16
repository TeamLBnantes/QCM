package fr.dawan.formation.AppQCMMono.Persistence;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.User;

public class TestDesignerDao {

	private DesignerDAO designerDao;
	private Designer designer;
	private int idDesigner;
	
	
	@Before
	public void testSaveOrUpdate() {	
		  designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); 
		  designer = new Designer();
		  designer.setPresentation("biologie777");
		  Assert.assertEquals(0L, designer.getId()); 
		  designerDao.saveOrUpdate(designer);
		  Assert.assertNotEquals(0L, designer.getId()); 
		  idDesigner=designer.getId();
		  designerDao.close();
	}
	
	@After
	public void testDeleteById() throws Exception {
		
		  designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); 
		  designer = designerDao.findById(Designer.class, idDesigner);
		  Assert.assertNotNull(designer); 
		  designerDao.deleteById(Designer.class,designer.getId()); 
		  designer = designerDao.findById(Designer.class,idDesigner); 
		  Assert.assertNull(designer); 
		  designerDao.close();
	}
	
	@Test
	public void testFindByKWPresentation() {
		designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); 
		List<Designer> designers = new ArrayList<>();
		int size = designers.size();
		designers = designerDao.searchByKW("77");
		Assert.assertEquals(size,designers.size());
		designer=new Designer();
		designer.setPresentation("999");
		designerDao.saveOrUpdate(designer);
		designers = designerDao.searchByKW("99");
		Assert.assertEquals(size+1,designers.size());
		designerDao.deleteById(Designer.class, designer.getId());
		designerDao.close();
	}

}
