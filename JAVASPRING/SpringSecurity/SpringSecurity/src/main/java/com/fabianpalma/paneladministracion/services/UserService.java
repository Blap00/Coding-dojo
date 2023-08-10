package com.fabianpalma.paneladministracion.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fabianpalma.paneladministracion.models.User;
import com.fabianpalma.paneladministracion.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
     //registrar el usuario y hacer Hash a su password
    public User registerUser(User user) {
    	if (userRepository.countAdmins() == 0) {
            user.setAdmin(true);
        }
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

	// encontrar un usuario por su email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // encontrar un usuario por su id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    //autenticar usuario
    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepository.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void updateUser(User user) {
        // Verificar si la pregunta ya existe en la base de datos
        if (user.getId() != null && userRepository.existsById(user.getId())) {
            userRepository.save(user);
        } else {
            // Si la pregunta no existe en la base de datos, se puede lanzar una excepción,
            // manejar el caso según tus requerimientos
            throw new IllegalArgumentException("El usuario no existe en la base de datos.");
        }
    }
    
    public List<User> findAll() {
		return userRepository.findAll();
	}
    
    public void deleteUser(Long id) {
		userRepository.deleteById(id);

	}
    
    public void assignAdminRole(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setAdmin(true);
            userRepository.save(user);
        }
    }
	
}

