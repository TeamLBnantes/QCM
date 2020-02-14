package fr.dawan.formation.AppQCMMono.TestPersisitence;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;
import fr.dawan.formation.AppQCMMono.Services.UserService;
import junit.framework.TestCase;

public class TestUserDao extends TestCase {
	
	private UserDAO userDao;
	private List<User> users;
	private User user;
	
	@BeforeClass
	public void testSaveOrUpdate() {
		
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = new User();
		
		user.setEmail("gj@gj.fr");
		user.setPassword("789");
		
		userDao.saveOrUpdate(user);
		
		assertNotNull(user.getId());
		userDao.close();
	}
	
	@Test
	public void testSearchByEmail() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = new User();
		
		user = userDao.searchByEmail("gj@gj.fr");
		assertEquals("789", user.getPassword());	
		userDao.close();
	}
	
	@Test
	public void testSearchByEmailService() {
		String email = "gj@gj.fr" ;
		String password = "789";
		
		UserService userService = new UserService();
		assertEquals(true,userService.controlLogin(email, password) );
	}
	
	@Test
	public void testSearchByEmailServiceFalse() {
		String email = "gj@gj.fr" ;
		String password = "7";
		
		UserService userService = new UserService();
		assertEquals(false,userService.controlLogin(email, password) );
	}

	@Test
	public void testSearchByDesigner() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		users = userDao.searchByDesigner(true);
		assertNotEquals(0, users.size());
		assertEquals(true, users.get(4).isDesigner());	
		//System.out.println(users);
		userDao.close();
	}
	
	@Test
	public void testSearchByPseudo() {
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		
		users = userDao.searchByPseudo("t4"); //je verifie que la chaine "t4"
		assertEquals(2, users.size());		//est présente dans 2 utilisateurs
		
		for (User user : users) {
			assertTrue(user.getPseudo().contains("t4"));
		}
		
		userDao.close();
	}
	
	
}
