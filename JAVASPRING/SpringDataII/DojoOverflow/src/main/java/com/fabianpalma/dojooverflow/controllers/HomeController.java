package com.fabianpalma.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fabianpalma.dojooverflow.models.Answer;
import com.fabianpalma.dojooverflow.models.Question;
import com.fabianpalma.dojooverflow.services.AnswerService;
import com.fabianpalma.dojooverflow.services.QuestionService;
import com.fabianpalma.dojooverflow.services.TagService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/questions")
public class HomeController {
	//GET SERVICES
	@Autowired
	private final AnswerService answerService;
	@Autowired
	private final QuestionService questionService;
	@Autowired
	private final TagService tagService;
	
	public HomeController(QuestionService questionService, AnswerService answerService, TagService tagService){
		this.answerService = answerService;
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	//GET METHOD
	@GetMapping("") // INDEX CON DASHBOARDS
	public String getIndex(Model model) {
		List<Question> questions = questionService.findAll();
	    model.addAttribute("questions", questions);
	    return "dashboard.jsp";
	}
	

	
	@GetMapping("/new") //Form to create a question
	public String getFormQuestion(Model model) {
		// Crear una nueva instancia de Question y asegurarse de que la lista tags esté inicializada
	    Question question = new Question();
	    question.setTags(new ArrayList<>());
	    
		model.addAttribute("question", new Question());
		return "questionForm.jsp";
	}
	
	@GetMapping("{id}")
	public String showQuestion(@PathVariable("id") Long questionId, Model model) {
	    // Obtener la pregunta por el id
	    Question question = questionService.findquestionById(questionId);

	    if (question == null) {
	        // Manejar el caso donde no se encontró la pregunta
	        return "error"; // (nombre de la vista de error)
	    }

	    // Obtener las respuestas para la pregunta
	    List<Answer> answers = answerService.findAnswerByQuestionId(question);

	    // Agregar la pregunta y las respuestas al modelo
	    model.addAttribute("question", question);
	    model.addAttribute("answers", answers);

	    // Agregar una instancia de Answer al modelo para el formulario de respuesta
	    model.addAttribute("answer", new Answer());

	    // Devolver la vista del formulario para responder la pregunta
	    return "questionAnsw.jsp";
	}
	
	//POST Method
	
	@PostMapping("/new")
	public String postNewQuestion(@ModelAttribute("question") Question question, Model model) {
	    try {
	        Question newQuestion = questionService.createQuestion(question, question.getTagsInput());
	        return "redirect:/questions/" + newQuestion.getId();
	    } catch (Exception e) {
	        model.addAttribute("error", "Error al crear la pregunta: " + e.getMessage());
	        System.out.println("Error al crear la pregunta: " + e.getMessage());
	        return "questionForm.jsp"; // Redirige nuevamente al formulario para corregir el error
	    }
	}

			
	@PostMapping("/{id}/post")
	public String postNewAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, @PathVariable(value = "id") Long id, Model model) {
	    if (result.hasErrors()) {
	        return "redirect:/questions/" + id;
	    } else {
	        answer.setQuestion(questionService.findquestionById(id)); // Asignar la pregunta a la respuesta
	        Answer newAnswer = new Answer();
	        newAnswer.setAnswerText(answer.getAnswerText());
	        newAnswer.setQuestion(answer.getQuestion());
	        
	        answerService.createAnswer(newAnswer);

	        // Recuperar todas las respuestas actualizadas relacionadas con la pregunta
	        List<Answer> updatedAnswers = answerService.findAnswerByQuestionId(id);

	        // Agregar la lista actualizada de respuestas al modelo
	        model.addAttribute("answers", updatedAnswers);

	        // También, asegúrate de agregar la pregunta al modelo nuevamente para mostrarla en la vista
	        Question question = questionService.findquestionById(id);
	        model.addAttribute("question", question);

	        return "questionAnsw.jsp";
	    }
	}


}
