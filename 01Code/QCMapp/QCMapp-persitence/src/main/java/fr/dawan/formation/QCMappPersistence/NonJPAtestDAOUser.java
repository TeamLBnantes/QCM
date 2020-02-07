package fr.dawan.formation.QCMappPersistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import fr.dawan.formation.QCMappModel.User;
import fr.dawan.formation.QCMappPersistenceDAO.NonJPADAOUser;

public class NonJPAtestDAOUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NonJPADAOUser daoUser = new NonJPADAOUser();
		
//===test de la DAOcreate
		User rantamplan=new User(0, "Laurent- connection 44", "taba","at@nantes.fr", "Kamikaze", false);
		//rantamplan.setSignInDate(date);
		//rantamplan.setLastConnectionDate(date1);
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		sdf.setLenient(false);
		try {
			java.util.Date inscription=sdf.parse("24-12-2019");
			java.util.Date dernierteConnction=sdf.parse("24-01-2044");
			rantamplan.setSignInDate(inscription);
			rantamplan.setLastConnectionDate(dernierteConnction);
		} catch (Exception e) {
			// TODO: handle exception
		}
		daoUser.create(rantamplan);

		
//=========test de DAOsearch by id
		System.out.println(daoUser.searchById(5));
		
//==========test update DOAuser
		User homer=daoUser.searchById(5);
		homer.setFirstName("elleSpide");
		daoUser.update(homer);
		System.out.println("cht du prenom de Mr Tabagnole");
		System.out.println(daoUser.searchById(5));

//===================test delete
		daoUser.delete(7);
		//daoUser.searchById(7); // pour vérifier qu'il n'est plus la
		
//====================test searchByDesigner		
		System.out.println("liste des utilisateur qui sont des designer : ");
		ArrayList<User> users = daoUser.searchByDesigner(true);
		//System.out.println(users);
		for (User element : users) {
			System.out.println(element);
		}
		System.out.println("liste des utilisateur qui  ne sont pas des designer : ");
		users = daoUser.searchByDesigner(false);
		//System.out.println(users);
		for (User element : users) {
			System.out.println(element);
		}
//====================test searchAll
		System.out.println("liste des utilisateurs : ");
		users = daoUser.searchAll();
		//System.out.println(users);
		for (User element : users) {
			System.out.println(element);
		}
		
//====================testByKw
		System.out.println("recherche chaine cal");
		users=daoUser.searchByKW("cal");
		for (User element : users) {
			System.out.println(element);
			}	
		
		
// ================test searchByDate sur derniere connection
		try {
			java.util.Date dateInf=sdf.parse("24-12-2025");
			java.util.Date dateSup=sdf.parse("24-12-2026");
			System.out.println("recherche par date");
			users=daoUser.searchByDate(dateInf, dateSup);
			for (User element : users) {
				System.out.println(element);
				}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
}
