package com.fabianpalma.listaestudiantes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.listaestudiantes.models.Classe;
import com.fabianpalma.listaestudiantes.models.Contact;
import com.fabianpalma.listaestudiantes.models.Dormitory;
import com.fabianpalma.listaestudiantes.models.Student;
import com.fabianpalma.listaestudiantes.services.ClasseService;
import com.fabianpalma.listaestudiantes.services.ContactService;
import com.fabianpalma.listaestudiantes.services.DormitoryService;
import com.fabianpalma.listaestudiantes.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private final StudentService studentService;
	@Autowired
	private final ContactService contactService;
	@Autowired
	private final DormitoryService dormitoryService;
	@Autowired
	private final ClasseService classeService;

	public ApiController(StudentService studentService, ContactService contactService,
			DormitoryService dormitoryService, ClasseService classeService) {
		this.studentService = studentService;
		this.contactService = contactService;
		this.dormitoryService = dormitoryService;
		this.classeService = classeService;
	}

	// METODOS API
	/**
	 * GET AREA
	 */
	/**
	 * Students
	 */
	// UPD ASSIGMENT 1
	@GetMapping("/students/create")
	public String createStudentGet(@ModelAttribute("student") Student student) {
		return "studentForm.jsp";
	}

	/**
	 * Contacts
	 */
	// Upd Assigment 1
	@GetMapping("/contacts/create")
	public String createContact(Model model, @ModelAttribute("contact") Contact contact) {
		List<Student> persons = studentService.nullStudent();
		model.addAttribute("persons", persons);
		return "contactForm.jsp";
	}

	/**
	 * Domitory
	 */
	// Upd Assigment 2
	@GetMapping("/dorms/{id}")
	public String getDorm(@PathVariable Long id, Model model) {
		Dormitory dorm = dormitoryService.findDormitory(id);
		List<Student> students = dorm.getStudents(); // Obtener los estudiantes del dormitorio
		List<Student> studentWithoutDorm = studentService.findStudentsWithoutDormitory();
		model.addAttribute("studentwithout", studentWithoutDorm);
		model.addAttribute("students", students);
		model.addAttribute("dorm", dorm);
		return "showDorms.jsp";
	}

	// Upd Assigment 2
	@GetMapping("/dorms/new")
	public String createDorm(Model model, @ModelAttribute("dormitory") Dormitory dormitory) {
		return "dormIndex.jsp";
	}

	/**
	 * Classes
	 */

	// UPD assigment 3
	@GetMapping("/classes/new")
	public String createClassGet(@ModelAttribute("classe") Classe classe) {
		return "classForm.jsp";
	}

	// UPD assigment 3
	@GetMapping("/classes/{id}")
	public String getClassById(@PathVariable Long id, Model model) {
		Optional<Classe> classe = classeService.findById(id);
		model.addAttribute("classe", classe.orElse(null));
		return "checkClass.jsp";
	}

	/**
	 * POST AREA
	 */
	/**
	 * Student
	 */
	// UPD assigment 1
	@PostMapping("/students/create")
	public String createStudentsPost(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return result.toString();
		} else {
			if ("John".equals(student.getFirstName()) && "Doe".equals(student.getLastName())
					&& student.getAge() == 35) {
				studentService.create3Student(student);
			} else {
				studentService.createStudent(student);
			}
			return "redirect:/api/students/create";
		}
	}

	/**
	 * Contacts
	 */
	// UPD assigment 1
	@PostMapping("/contacts/create")
	public String createContactsPost(@Valid @ModelAttribute("contactinfo") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return result.toString();
		} else {
			contactService.createContact(contact);
			return "redirect:/api/contacts/create";
		}
	}

	/**
	 * Dorms
	 */
	// UPD assigment 2
	@PostMapping("/dorms/create")
	public String createDormitory(@Valid @ModelAttribute("dormitory") Dormitory dormitory, BindingResult result,
			@RequestParam(value = "name") String name) {
		if (result.hasErrors()) {
			return "dormIndex.jsp";
		} else {
			dormitory.setName(name);
			dormitoryService.createDormitory(dormitory);
			Long id = dormitory.getId();
			return "redirect:/api/dorms/" + id;
		}
	}

	// UPD assigment 2
	@PostMapping("/dorms/{id}/add")
	public String addStudentToDorm(@PathVariable Long id, @RequestParam Long studentId) {
		Dormitory dorm = dormitoryService.findDormitory(id);
		Student student = studentService.findStudent(studentId);
		List<Student> updatedList = dorm.getStudents();
		updatedList.add(student);
		dorm.setStudents(updatedList);
		student.setDormitory(dorm);
		studentService.createStudent(student);
		dorm.getStudents().add(student); // Agregar el estudiante al dormitorio
		dormitoryService.createDormitory(dorm); // Guardar los cambios en la base de datos
		return "redirect:/api/dorms/" + id;
	}

	// UPD assigment 2
	@PostMapping("/dorms/{id}/remove")
	public String removeStudentFromDorm(@PathVariable Long id, @RequestParam Long studentId) {
		Dormitory dorm = dormitoryService.findDormitory(id);
		Student student = studentService.findStudent(studentId);

		System.out.println(studentId);
		if (dorm != null && student != null) {
			dorm.getStudents().remove(student); // Remover el estudiante del dormitorio
			student.setDormitory(null); // Remover la relación entre el estudiante y el dormitorio
			dormitoryService.createDormitory(dorm); // Guardar los cambios en la base de datos
			studentService.createStudent(student); // Guardar los cambios en la base de datos del estudiante
		}

		return "redirect:/api/dorms/" + id;
	}

	/**
	 * Classes
	 */
	// Upd Assigment 3
	@PostMapping("/classes/create")
	public String createClassPost(@Valid @ModelAttribute("classe") Classe classe, BindingResult result) {
		if (result.hasErrors()) {
			return "classForm.jsp";
		} else {
			classeService.createClasse(classe);
			return "redirect:/api/classes/new";
		}
	}

	/**
	 * UPDATE 3 Lista estudiante 3 assigment
	 */
	// GET MAPPING

	// UPD assigment 3
	@GetMapping("/students/{id}")
    public String getStudentId(@PathVariable Long id, Model model) {
		Optional<Student> student = studentService.findById(id);

	    if (student.isPresent()) {
	        Student foundStudent = student.get();
	        List<Classe> classesNotInStudent = classeService.findAllClassesNotInStudent(foundStudent);
	        model.addAttribute("studentId", foundStudent.getId());
	        model.addAttribute("student", foundStudent);
	        model.addAttribute("classesNotInStudent", classesNotInStudent);
	    } else {
	        model.addAttribute("studentId", id);
	        model.addAttribute("student", null);
	        model.addAttribute("classesNotInStudent", classeService.allClasse());
	    }

        return "checkStudent.jsp";
    }
	

	// POST MAPPING

	// Upd Assigment 3
	@PostMapping("/students/{studentId}/add")
	public String addClassToStudent(@PathVariable Long studentId, @RequestParam List<Long> classes) {
		boolean added = false;
	    for (Long classId : classes) {
	        added = classeService.addClassToStudent(classId, studentId);
	    }
		// Handle success or failure accordingly, e.g., show a success or error message
		// on the page
		return added ? "redirect:/api/students/" + studentId : "redirect:/api/classes/create";
	}

	@PostMapping("/students/{studentId}/remove")
	public String removeStudentId(@PathVariable Long studentId, @RequestParam("classeId") Long classeId) {
		studentService.removeClassFromStudent(studentId, classeId);

        // Después de eliminar la clase, puedes redirigir al usuario a una página de éxito o donde prefieras.
        return "redirect:/api/students/"+studentId;
	}

}
