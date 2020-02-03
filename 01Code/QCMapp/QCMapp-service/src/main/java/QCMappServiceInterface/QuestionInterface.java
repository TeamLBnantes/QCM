package QCMappServiceInterface;

import java.util.ArrayList;

import fr.dawan.formation.QCMappModel.Question;
import fr.dawan.formation.QCMappModelEnum.Status;

public interface QuestionInterface {

	
	//les "passe plat" vers DAOQusetion
	
	public void create(Question question);
	public void update(Question question);
	public void delete(int idQuestion);
	public Question searchById (int idQuestion);
	public ArrayList<Question> searchByTheme (String theme);
	public ArrayList<Question> searchByStatus (Status status);
	public ArrayList<Question> searchByKWBody (String kw);
	public ArrayList<Question> searchAll ();
	public ArrayList<Question> searchByDesigner (int idDesigner);
	
	
	//les autres
	public ArrayList<Boolean> evaluateQuestion (String[] args);
	//le tableau d'argument contiendra les id de reponses et les valeur de reponse faite par utilisateur
	// permettra de retourner les erreurs ou non pour chacune des lignes reponse
	
	//il serait aussi possible de faire un objet hashmap pour l'ensemble de la base.
	//ou encore un objet couple (id-rep, rep) pour pouvoir stocker et faire passer les elt
	// de methode en methodes dans des arraylist
	
	
	

	
}
