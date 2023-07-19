package com.reto01.grupog6.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto01.grupog6.CrudRepository.UserCrudRepository;
import com.reto01.grupog6.Entities.User;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public User addUser(User user) {
        return userCrudRepository.save(user);
    }

    public boolean getValidateEmail(String email) {
        Optional<User> miUsuario = userCrudRepository.findbyEmail(email);

        if (miUsuario.isEmpty())
            return false;
        else
            return true;
    }
    
    public User getLogin(String email, String password) {
        Optional<User> miUsuario = userCrudRepository.findbyEmailandPassword(email, password);
        User usuarioRespuesta = new User();

        if (miUsuario.isEmpty()) {
            usuarioRespuesta.setEmail(email);
            usuarioRespuesta.setPassword(password);
            usuarioRespuesta.setName("NO DEFINIDO");
            usuarioRespuesta.setId(null);
         } 
         else {
             usuarioRespuesta = miUsuario.get();
         }
         return usuarioRespuesta;
    }

}
