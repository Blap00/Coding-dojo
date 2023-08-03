package com.fabianpalma.listaestudiantes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.listaestudiantes.models.Classe;
import com.fabianpalma.listaestudiantes.models.Student;
import com.fabianpalma.listaestudiantes.repositories.ClasseRepository;
import com.fabianpalma.listaestudiantes.repositories.StudentRepository;

@Service
public class ClasseService {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private StudentRepository studentRepository;

	public ClasseService(ClasseRepository classeRepository, StudentRepository studentRepository) {
		this.classeRepository = classeRepository;
		this.studentRepository = studentRepository;
	}

	// GET ALL ON CATEGORIES (R)
	public List<Classe> allClasse() {
		return classeRepository.findAll();
	}


	// GET by ID
	public Optional<Classe> findById(Long id) {
		return classeRepository.findById(id);
	}

	// Create or Upadte
	public Classe createClasse(Classe c) {
		return classeRepository.save(c);
	}

	// Delete
	public void deleteCategory(Long id) {
		classeRepository.deleteById(id);
	}

    // Method to add a class to a student
    public boolean addClassToStudent(Long classId, Long studentId) {
        Optional<Classe> classeOptional = classeRepository.findById(classId);
        if (classeOptional.isPresent()) {
            Optional<Student> studentOptional = studentRepository.findById(studentId);
            if (studentOptional.isPresent()) {
                Classe classe = classeOptional.get();
                Student student = studentOptional.get();
                List<Classe> classes = student.getClasses();
                classes.add(classe);
                student.setClasses(classes);
                studentRepository.save(student);
                return true;
            }
        }
        return false;
    }
    // Get all classes not associated with a student
    public List<Classe> findAllClassesNotInStudent(Student student) {
        List<Classe> allClasses = allClasse();
        List<Classe> classesNotInStudent = new ArrayList<>();

        for (Classe classe : allClasses) {
            if (!student.getClasses().contains(classe)) {
                classesNotInStudent.add(classe);
            }
        }

        return classesNotInStudent;
    }

}
