package fr.dawan.QuestionQCM.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.QuestionQCM.Beans.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Query("select q from Question q join fetch q.designer d")
	public List<Question> findAll2 ();
	// TO DO
	// Page<Question> findByBodyContaining(String kw, Pageable p);
	
}


