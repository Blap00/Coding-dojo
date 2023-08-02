package com.fabianpalma.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabianpalma.dojooverflow.models.Question;
import com.fabianpalma.dojooverflow.models.Tag;
import com.fabianpalma.dojooverflow.repositories.QuestionRepository;
import com.fabianpalma.dojooverflow.repositories.TagRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	private final TagRepository tagRepository;
	
	public QuestionService(QuestionRepository questionRepository, TagRepository tagRepository) {
		this.questionRepository = questionRepository;
		this.tagRepository = tagRepository;	
	}
	
	public List<Question> findAll(){ //GET ALL questionS IN DBA
		return questionRepository.findAll();
	}
	
	public Question findquestionById(Long id) {
		Optional<Question> optQuest= questionRepository.findById(id);
		if(optQuest.isPresent()) {
			return optQuest.get();
		}else {
			return null;
		}
	}
	
	@Transactional
	public Question createQuestion(Question question, String tagsString) {
	    // Parsear la cadena de texto de etiquetas a una lista de etiquetas
	    List<Tag> tags = parseTagsString(tagsString);

	    // Asignar la lista de etiquetas a la pregunta
	    question.setTags(tags);

	    // Guardar la pregunta en la base de datos (puedes tener más lógica aquí)
	    return questionRepository.save(question);
	}

	private List<Tag> parseTagsString(String tagsString) {
	    List<Tag> tags = new ArrayList<>();
	    String[] tagNames = tagsString.split(",");

	    for (String tagName : tagNames) {
	        Tag tag = tagRepository.findBySubject(tagName.trim()); // Elimina espacios en blanco
	        if (tag == null) {
	            tag = new Tag(tagName.trim()); // Elimina espacios en blanco
	            tagRepository.save(tag);
	        }
	        tags.add(tag);
	    }

	    return tags;
	}
	
	
	public Question updatequestion(Question question) {
		return questionRepository.save(question);
	}
	
	public void deletequestion(Long id) {
		questionRepository.deleteById(id);
	}
	
}
