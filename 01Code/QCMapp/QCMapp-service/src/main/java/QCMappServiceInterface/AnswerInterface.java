package QCMappServiceInterface;

import java.util.ArrayList;

import fr.dawan.formation.AppQCMMono.Models.Answer;

public interface AnswerInterface {
	
//celles qui ne font que du "passe plat" DAOAnswer
	public void create(Answer answer);
	public void update(Answer answer);
	public void delete(int idAnswer);
	public Answer searchById (int idAnswer);
	public ArrayList<Answer> searchByIdQuestion (int idQuestion);
	
//les autres
	public boolean evalateAnswer(boolean answerUser);

	
}
