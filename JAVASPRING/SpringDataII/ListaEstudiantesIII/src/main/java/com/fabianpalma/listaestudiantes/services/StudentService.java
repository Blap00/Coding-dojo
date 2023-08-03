package com.fabianpalma.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.listaestudiantes.models.Classe;
import com.fabianpalma.listaestudiantes.models.Student;
import com.fabianpalma.listaestudiantes.repositories.ClasseRepository;
import com.fabianpalma.listaestudiantes.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;
	@Autowired
	private final ClasseRepository classRepository;
	

	public StudentService(StudentRepository studentRepository, ClasseRepository classRepository) {
		this.studentRepository = studentRepository;
		this.classRepository = classRepository;
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
    
    

    public Student findStudent(Long id) {
        Optional<Student> opStudent = studentRepository.findById(id);
        if(opStudent.isPresent()) {
            return opStudent.get();
        } else {
            return null;
        }
    }
    
    public List<Student> findStudentsWithoutDormitory() {
        return studentRepository.findAllByDormitoryIsNull();
    }
    
 // Método para eliminar una clase de un estudiante
    public boolean removeClassFromStudent(Long studentId, Long classId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Classe classe = classRepository.findById(classId).orElse(null);

        if (student == null || classe == null) {
            // Si el estudiante o la clase no existen, no se puede eliminar la clase del estudiante.
            return false;
        }

        // Verifica si el estudiante tiene la clase antes de eliminarla
        if (!student.getClasses().contains(classe)) {
            // Si el estudiante no tiene la clase, no se puede eliminar.
            return false;
        }

        // Elimina la clase del estudiante y guarda los cambios en la base de datos
        student.getClasses().remove(classe);
        studentRepository.save(student);
        return true;
    }
    
}
