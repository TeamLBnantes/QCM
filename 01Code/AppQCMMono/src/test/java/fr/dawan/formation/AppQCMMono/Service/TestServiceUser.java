package fr.dawan.formation.AppQCMMono.Service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Services.UserService;

public class TestServiceUser {

	
	private UserService service = new UserService();
	
	
	@Test
	public void testSearchByEmailUserService() {
		User user = service.searchByEmail("hp@dawan.fr");
		assertNotNull(user);
	}

}
