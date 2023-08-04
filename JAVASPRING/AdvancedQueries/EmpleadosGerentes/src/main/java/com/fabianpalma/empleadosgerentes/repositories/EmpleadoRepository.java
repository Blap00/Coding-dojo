package com.fabianpalma.empleadosgerentes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.empleadosgerentes.models.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado,Long>{

	List<Empleado> findAll();
	
	@Query("SELECT e, e.manager.id FROM Empleado e WHERE e.manager.id = ?1 AND e.id != ?1")
    List<Object[]> findEmployeesByManagerId(Long managerId);
    
    @Query("SELECT e, "
    		+"Case when e.id = e.manager.id then 'Si' else 'No' End "
    		+"FROM Empleado e Where e.id=?1")
    List<Object[]> findByIdQueries(Long id);
    
    Optional<Empleado> findById(Long id);
    
}
