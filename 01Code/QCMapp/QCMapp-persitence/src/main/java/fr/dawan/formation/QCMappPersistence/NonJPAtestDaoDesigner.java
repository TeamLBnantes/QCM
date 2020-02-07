package fr.dawan.formation.QCMappPersistence;


import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import fr.dawan.formation.QCMappModel.Designer;
import fr.dawan.formation.QCMappModelEnum.Status;
import fr.dawan.formation.QCMappPersistenceDAO.NonJPADAODesigner;


public class NonJPAtestDaoDesigner {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		NonJPADAODesigner daoDesigner = new NonJPADAODesigner();
		
		
		 //test methode create
		//Date date1 = new Date ();
		//Designer rep1=new Designer(0,"ihegmesf", date1, "foihqefmizqzfhomzefhom", true);
		//daoDesigner.create(rep1);
		//daoDesigner.delete(3);
		/*	
		//test methode searchById
		rep1=daoDesigner.searchById(1);
		System.out.println(rep1.toString());
	
		//test update de la question d'id 5
		rep1=new Designer(2,"ihegmegrsrghdgdgdgsdgsgvsvsf", date1, "jomfhmzqhn", true);
		daoDesigner.update(rep1);
		
		//test searchByIdQuestion. Rcherche des reponses dont la question est d'ID 1177
		ArrayList<Question> tabQuestion=new ArrayList<Question>();
		tabQuestion=daoQuestion.searchByDesigner(1177);
		System.out.println("rep trouvées : ");
		for (Question question : tabQuestion) {
			System.out.println(question);
		
	}
	*/
		try {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		sdf.setLenient(false);
		
		java.util.Date d1=sdf.parse("01-03-2016");
		//java.util.Date d = new java.util.Date();
		//java.sql.Date sd = new java.sql.Date(d1.getTime());
		int id= (int)(Math.random() * 10000);
		Designer rep2=new Designer(id,"Mourad2- 01-03-16", d1, "gggggggg", true);
		daoDesigner.create(rep2);
		
//		d1=sdf.parse("01-01-2025");
//		java.util.Date dateA = new java.util.Date(d1.getTime());
		java.util.Date dateA = sdf.parse("01-01-2066");
		System.out.println(dateA);
//		 d1=sdf.parse("31-12-2030");
//		java.util.Date dateB = new java.util.Date(d1.getTime());
		java.util.Date dateB =sdf.parse("31-12-2066");
		
		System.out.println(dateB);
		ArrayList<Designer> designers = daoDesigner.searchByDate(dateA, dateB);
		System.out.println("liste des designer recherchés par date (tableau puis par ligne");
		System.out.println(designers);
		System.out.println("donc par ligne :");
		for (Designer designer : designers) {
			System.out.println(designer.toString());
			
			
		}
		} catch (Exception e) {
			
			
			
		// TODO: handle exception
		}
		// select all
		ArrayList<Designer> alldesigners = daoDesigner.searchAll();
		System.out.println("alldesigner++++++++++++++++++");
		System.out.println(alldesigners);
		
		for (Designer designer : alldesigners) {
			System.out.println(designer.toString());
	}
		
	}
}
