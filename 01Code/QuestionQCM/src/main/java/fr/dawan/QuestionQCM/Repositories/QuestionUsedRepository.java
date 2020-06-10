package fr.dawan.QuestionQCM.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.QuestionQCM.Beans.AdminTechniqueAppli;
import fr.dawan.QuestionQCM.Beans.MCQ;
import fr.dawan.QuestionQCM.Beans.Question;
import fr.dawan.QuestionQCM.Beans.QuestionUsed;


public interface QuestionUsedRepository extends JpaRepository<QuestionUsed, Integer> {


	// TO DO
	@Query("select q from QuestionUsed q where q.mcq = ?1 and q.question = ?2")
	public QuestionUsed findQuestionUsed (MCQ mcq, Question question);
	
}


