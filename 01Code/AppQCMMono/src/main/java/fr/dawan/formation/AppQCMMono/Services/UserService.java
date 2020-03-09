package fr.dawan.formation.AppQCMMono.Services;

import java.time.LocalDateTime;

import javax.persistence.NoResultException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dawan.formation.AppQCMMono.Models.Designer;
import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Models.objectBooleanString;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;

@Service
public class UserService {

	

	public boolean controlLogin(String email, String password) {
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		User userLogin = null;
		
		try {
			userLogin = userDao.searchByEmail(email);
		} catch (NoResultException ex) {
			System.out.println("Utilisateur non trouvé");
		}
	
		userDao.close();
		if (userLogin != null) {
			

			//if (password.equals(userLogin.getPassword())) {
			if (BCrypt.checkpw(password, userLogin.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		 
	}
	
	public User searchByEmail(String email) {
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		User user=userDao.searchByEmail(email);
		userDao.close();
		return user;
	}

	public objectBooleanString createUser(User user, String confirmPassword, String confirmEmail) {
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		objectBooleanString objReturn=new objectBooleanString();
		objReturn.setAnswer(false);
		
		
		if (userDao.searchByEmail(user.getEmail())!=null) {
			objReturn.setComment("l'utilisateur existe déjà");
		} else if (user.getFirstName()==""||user.getFirstName().length()<=1) {
				objReturn.setComment("Prénom invalide");
		}else if(user.getLastName()==""||user.getLastName().length()<=1) {
				objReturn.setComment("Nom invalide");			
		}else if(!(user.getPassword().equals(confirmPassword))) {
			objReturn.setComment("Confirmation du mot de passe non conforme");
		}else if(!(user.getEmail().equals(confirmEmail))){
			objReturn.setComment("Confirmation de l'Email non conforme");	
			
		
		}else {
			String pwd=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setLastName(user.getLastName().toUpperCase());
			user.setPassword(pwd);
			user.setSignInDate(LocalDateTime.now());
			userDao.saveOrUpdate(user);
			objReturn.setAnswer(true);
		}
		userDao.close();
		return objReturn;
	}

	public void saveOrUpdate(User user) {
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		userDao.saveOrUpdate(user);
		userDao.close();
	}

	public User createUserDesigner(User user, Designer designer) {
		// TODO empecher le lien vers la creation de designer pour un user qui en est deja un !
		//unicité du designer est géré via jpa, joincolum dans la classe designer
		//unique = true
		
		user.setDesigner(designer);
		designer.setUser(user);
		designer.setDateStatus(LocalDateTime.now());
		saveOrUpdate(user);

		
		user = findById(user.getId());		
		// je n'écrit pas le designer car j'ai mis une cascade sur le mappedBy de User
		return user;
		

	}

	public User findById(int id) {
		UserDAO userDao = new UserDAO(Constantes.PERSISTENCE_UNIT_NAME);
		User u=userDao.findById(User.class, id);
		userDao.close();
		return u;
	}
	

	
	
	
	

	
}