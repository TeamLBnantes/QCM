package fr.dawan.QuestionQCM.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.QuestionQCM.Beans.Question;

public interface AnswerRepository extends JpaRepository<Question, Integer> {


	// TO DO
	// Page<Question> findByBodyContaining(String kw, Pageable p);
	
}


