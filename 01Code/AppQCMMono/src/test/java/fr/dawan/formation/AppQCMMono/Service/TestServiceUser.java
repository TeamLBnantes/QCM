package fr.dawan.formation.AppQCMMono.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.dawan.formation.AppQCMMono.Models.SubscribeValidator;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.UserService;

public class TestServiceUser {

	
	private UserService service = new UserService();
	
	
	@Test
	public void testSearchByEmailUserService() {
		User user = service.searchByEmail("hp@dawan.fr");
		assertNotNull(user);
	}
	
	
	@Test
	public void testControlLoginServiceUserTrue() {
		Boolean userLogin = service.controlLogin("hp@dawan.fr", "123");
		assertTrue(userLogin);
	}

	@Test
	public void testControlLoginServiceUserFalsePwd() {
		Boolean userLogin = service.controlLogin("hp@dawan.fr", "666");
		assertFalse(userLogin);
	}
	
	@Test
	public void testControlLoginServiceUserFalseEmail() {
		Boolean userLogin = service.controlLogin("hp@dawan.com", "123");
		assertFalse(userLogin);
	}
	
	@Test
	public void testCreateUserUserService() {
		User user = service.searchByEmail("hp@dawan.fr");
		SubscribeValidator subsVal = service.createUser(user);
		assertEquals("l'utilisateur existe déjà", subsVal.getComment());
	}
}
