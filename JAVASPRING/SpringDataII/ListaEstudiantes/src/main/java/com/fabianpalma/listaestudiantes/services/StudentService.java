package com.fabianpalma.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.listaestudiantes.models.Student;
import com.fabianpalma.listaestudiantes.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// GET ALL ON CATEGORIES (R)
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}

	public List<Student> nullStudent() {
        return studentRepository.findByContactIsNull();
    }

	// GET by ID
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}
	
	
	// Create or Upadte
	public Student createStudent(Student s) {
		return studentRepository.save(s);
	}
	public void create3Student(Student s) {
		Student student1 = new Student(s.getFirstName(), s.getLastName(), s.getAge());
	    Student student2 = new Student(s.getFirstName(), s.getLastName(), s.getAge());
	    Student student3 = new Student(s.getFirstName(), s.getLastName(), s.getAge());

	    studentRepository.save(student1);
	    studentRepository.save(student2);
	    studentRepository.save(student3);
		
	}

	// Delete
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
