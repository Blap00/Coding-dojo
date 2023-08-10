package com.fabianpalma.paneladministracion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.paneladministracion.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findByEmail(String email); //cree un método que recupere un usuario específico por su email.
	List<User> findAll();
	@Query("SELECT COUNT(u) FROM User u WHERE u.admin = true")
    long countAdmins();
    
}
