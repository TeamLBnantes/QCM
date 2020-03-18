package fr.dawan.QuestionQCM.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.dawan.QuestionQCM.Beans.MCQ;

public interface QCMRepository extends JpaRepository<MCQ, Integer> {
	
	@Query("select m from MCQ m join fetch m.designer d join fetch d.user")
	public List<MCQ> findAll2 ();

	// TO DO
	// Page<Question> findByBodyContaining(String kw, Pageable p);
	
}


