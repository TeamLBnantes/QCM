package fr.dawan.formation.AppQCMMono.Persistence;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.User;

public class TestGenericDao {

	private UserDAO userDao;
	private User user;
	private int id;
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
		Assert.assertEquals(0L, user.getId());
		userDao.saveOrUpdate(user);
		Assert.assertNotEquals(0L, user.getId());
		id = user.getId();
		userDao.close();

		 
	}
	
	@Test
	public void testDeleteById() throws Exception {
		
		userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		user = userDao.findById(User.class, id);
		Assert.assertNotNull(user);
		userDao.deleteById(User.class, user.getId());
		user = userDao.findById(User.class, id);
		Assert.assertNull(user);
		userDao.close();
	}

}
