package fr.dawan.formation.AppQCMMono;

import fr.dawan.formation.AppQCMMono.Models.Answer;
import fr.dawan.formation.AppQCMMono.Models.Designer;

 
/**
 * presentation de la classe test.
 * @author laurent.boureau
 *
 */

public class test {

	
	
	/**
	 * info sur l'attribu id de la classe test
	 * @author laurent.boureau
	 *
	 */
	private static int id;
	/**
	 * presentation de la methode main.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * presentation de l'objet d.
		 * de type designer et créé dans la methode main
		 * @param args
		 */
		Designer d = new Designer();
				
		Answer a= new Answer();
				
		id=2;
		id=d.getId();
		System.out.println(d);
	}

}
