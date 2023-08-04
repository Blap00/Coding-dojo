package com.fabianpalma.empleadosgerentes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabianpalma.empleadosgerentes.models.Empleado;
import com.fabianpalma.empleadosgerentes.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	private final EmpleadoRepository empleadoRepository;

	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	// Devolviendo todos los libros.
	public List<Empleado> allEmployees() {
		return empleadoRepository.findAll();
	}

	public List<Object[]> findEmployeer(Long id) {
		return empleadoRepository.findByIdQueries(id);
	}
	
	public List<Object[]> findEmployerById(Long managerId){
		return empleadoRepository.findEmployeesByManagerId(managerId);
	}

	// Creando un libro.
	public Empleado createEmployeer(Empleado b) {
		return empleadoRepository.save(b);
	}

	public EmpleadoRepository getEmployeerRepository() {
		return empleadoRepository;
	}

	public void deleteEmployeer(Long id) {
		empleadoRepository.deleteById(id);
	}

	public Empleado findById(Long id) {
		Optional<Empleado> optEmp= empleadoRepository.findById(id);
		if(optEmp.isPresent()) {
			return optEmp.get();
		}
		else {
			return null;
		}
	}
}
