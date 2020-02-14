package fr.dawan.formation.AppQCMMono.Services;

import javax.persistence.NoResultException;

import fr.dawan.formation.AppQCMMono.Models.User;
import fr.dawan.formation.AppQCMMono.Persistence.Constantes;
import fr.dawan.formation.AppQCMMono.Persistence.UserDAO;

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
			if (password.equals(userLogin.getPassword())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		 
	}

}