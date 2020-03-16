package fr.dawan.formation.AppQCMMono.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;
import fr.dawan.formation.AppQCMMono.Services.UserService;
import junit.framework.TestCase;

public class TestUserDao {
	
	private UserDAO userDao;
	private DesignerDAO designerDao;
	private List<User> users;
	private User user;
	private Designer designer;
	private int id;
	private int idDesigner;
	
	@Before
	public void testSaveOrUpdate() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = new User();
		user.setEmail("gj@gj.fr");
		user.setPassword("789");
		user.setPseudo("gj");
		user.setSignInDate(LocalDateTime.now());
		//user.setLastConnectionDate(LocalDateTime.plusDays(20));
		Assert.assertEquals(0L, user.getId());
		userDao.saveOrUpdate(user);
		Assert.assertNotEquals(0L, user.getId());
		id=user.getId();
		userDao.close();
		
		/*
		 * designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); designer =
		 * new Designer(); designer.setUser(user); Assert.assertEquals(0L,
		 * designer.getId()); designerDao.saveOrUpdate(designer);
		 * Assert.assertNotEquals(0L, designer.getId()); idDesigner=designer.getId();
		 * designerDao.close();
		 */
		
		
		
		
		
		
	}
	
	@After
	public void testDeleteById() throws Exception {
		/*
		 * designerDao = new DesignerDAO(Constantes.PERSISTENCE_UNIT_NAME); designer =
		 * designerDao.findById(Designer.class, idDesigner);
		 * Assert.assertNotNull(designer); designerDao.deleteById(Designer.class,
		 * designer.getId()); designer = designerDao.findById(Designer.class,
		 * idDesigner); Assert.assertNull(designer); designerDao.close();
		 */
		
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = userDao.findById(User.class, id);
		Assert.assertNotNull(user);
		userDao.deleteById(User.class, user.getId());
		user = userDao.findById(User.class, id);
		Assert.assertNull(user);
		userDao.close();
	}
	 
	
	@Test
	public void testSearchByEmail() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = userDao.searchByEmail("gj@gj.fr");
		assertEquals("gj@gj.fr", user.getEmail());	
		userDao.close();
	}
	
	@Test
	public void testSearchByEmailFalse() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = userDao.searchByEmail("gj@gj.fr");
		assertNotEquals("77@77.fr", user.getEmail());	
		userDao.close();
	}
	
	/*
	 * @Test public void testSearchByEmailService() { String email = "gj@gj.fr" ;
	 * String password = "789";
	 * 
	 * UserService userService = new UserService();
	 * assertEquals(true,userService.controlLogin(email, password) ); }
	 * 
	 * @Test public void testSearchByEmailServiceFalse() { String email = "gj@gj.fr"
	 * ; String password = "7";
	 * 
	 * UserService userService = new UserService();
	 * assertEquals(false,userService.controlLogin(email, password) ); }
	 */

	/*
	 * @Test public void testSearchByDesigner() { userDao = new
	 * UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
	 * 
	 * users = userDao.searchByDesigner(true); assertNotEquals(0, users.size());
	 * assertEquals(true, users.get(4).isDesigner()); //System.out.println(users);
	 * userDao.close(); }
	 */
	
	@Test
	public void testSearchByPseudo() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		users = userDao.searchByPseudo("gj"); //je verifie que la chaine "gj"
		assertEquals(1, users.size());		//est présente dans 1 utilisateur
		
		for (User user : users) {
			assertTrue(user.getPseudo().contains("gj"));
		}
		userDao.close();
	}
	
	
	
}
