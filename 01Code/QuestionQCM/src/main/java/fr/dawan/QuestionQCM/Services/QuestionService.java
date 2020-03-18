package fr.dawan.QuestionQCM.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.QuestionQCM.Beans.Question;
import fr.dawan.QuestionQCM.Repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository repository;
	
	public Question find(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Question> findAll() {
		return repository.findAll2();
	}

	public Question create(Question m) {
		// Le flush permet de faire un commit intermédiare, en cours de la transaction
		// repository.flush();
		return repository.save(m);
	}

	public Question update(Question m) {
		if (!repository.existsById(m.getId())) {
			throw new RuntimeException("Le Question n'existe pas");
		}
		return repository.save(m);
	}

	public boolean delete(int id) {
		repository.deleteById(id);
		repository.flush();
		return !repository.existsById(id);
	}
	
	
}
