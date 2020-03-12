package fr.dawan.formation.AppQCMMono;

import static org.junit.Assert.*;

import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import fr.dawan.formation.AppQCMMono.Models.Question;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.QuestionDAO;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;
import fr.dawan.formation.AppQCMMono.Services.UserService;

public class TestModificationInformationsUser {

	private UserService userService;
	private User user;
	private UserDAO userDao;
	private int id; 
	
	
	
	@Before
	public void createUser() throws Exception {
		userService = new UserService();
		user = new User();
		user.setEmail("tintin@tt.fr");
		user.setFirstName("tintin");
		user.setLastName("toto");
		user.setPassword("666");
		String pwd=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(pwd);
		System.out.println("CREATION"+"*****"+user.getPassword());
		id=user.getId();
		userService.saveOrUpdate(user);
	}

	@After
	public void testDeleteById() throws Exception {
		userService = new UserService();
		userService.deleteById(user, id);
	}

	@Test
	public void testUpdateInformationsUser() {
		user.setEmail("tintin@tt.fr");
		user.setFirstName("ppp");
		user.setLastName("aaa");
		user.setPassword("111");
		String pwd=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(pwd);
		id=user.getId();
		userService.saveOrUpdate(user);
		System.out.println("UPDATE"+"*************"+user.getEmail()+"*******************"+user.getPassword());
		
	}

}
