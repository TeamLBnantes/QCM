package fr.dawan.formation.AppQCMMono.Persistence;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.MCQ;
import fr.dawan.formation.AppQCMMono.Models.User;

public class TestDesignerDao {

	private UserDAO userDao;
	private DesignerDAO designerDao;
	private List<User> users;
	private User user;
	private Designer designer;
	private int id;
	private int idDesigner;
	private String uuid;
	
	
	@Before
	public void testSaveOrUpdate() {	
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = new User();
		uuid = UUID.randomUUID().toString();
		user.setEmail(uuid+"@gj.fr");
		user.setPassword("789");
		user.setPseudo("gj");
		user.setSignInDate(LocalDateTime.now());
		// user.setLastConnectionDate(LocalDateTime.plusDays(20));
		Assert.assertEquals(0L, user.getId());
		userDao.saveOrUpdate(user);
		Assert.assertNotEquals(0L, user.getId());
		id = user.getId();
		userDao.close();

		designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME);
		designer = new Designer();
		designer.setUser(user);
		designer.setPresentation("je me presente");
		designer.setExpertiseField("biologie et cuisine");
		Assert.assertEquals(0L, designer.getId());
		designerDao.saveOrUpdate(designer);
		Assert.assertNotEquals(0L, designer.getId());
		idDesigner = designer.getId();
		designerDao.close();
	}
	
	@After
	public void testDeleteById() throws Exception {
		
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = userDao.findById(User.class, id);
		Assert.assertNotNull(user);
		userDao.deleteById(User.class, user.getId());
		user = userDao.findById(User.class, id);
		Assert.assertNull(user);
		userDao.close();
	}
	
	@Test
	public void testFindByKWPresentation() {
		designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); 
		List<Designer> designers = new ArrayList<>();
		//int size = designers.size();
		designers = designerDao.searchByKW("pres");
		Assert.assertEquals(designer.getPresentation(),designers);
		/*
		 * designer=new Designer(); designer.setPresentation("999");
		 * designerDao.saveOrUpdate(designer); designers = designerDao.searchByKW("99");
		 * Assert.assertEquals(size+1,designers.size());
		 * designerDao.deleteById(Designer.class, designer.getId());
		 */
		designerDao.close();
	}
	
	@Test
	public void testDesignerSearchByDate() {
		
	}

}
