package com.example.apirest.model.serveis;

import com.example.apirest.model.entitats.Usuari;
import com.example.apirest.model.repositoris.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeisUser {

    private final UserRepository userRepository;

    private final PasswordEncoder xifrat;
    public Usuari consultarPerUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public Usuari crearNouUsuari(Usuari nouUsuari) {
        //falta controlar que els 2 passwords del client coincideixen
        //passar un UsuariCreacioDTO
        nouUsuari.setPassword(xifrat.encode(nouUsuari.getPassword()));
        userRepository.save(nouUsuari);
        return nouUsuari;
    }
    //llistar tots els user
    public List<Usuari> get() {
        return userRepository.findAll();
    }

    //consultar user per id
    public Usuari getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    //afegir user
    public Usuari set(Usuari it) {
        return userRepository.save(it);
    }


    /*//modificar sencer, si existeix el canvia, sino retorna null
    public User update(User user){
        //User user = userRepository.findById(id).orElse(null);
        //user = it;
        //user.setIdUser(it.getIdUser());
        //user.setSession(it.getSession());
        userRepository.save(user);
        return user;
    }*/

    //eliminar user per id
    //si no existeix id retorna null
    public Usuari delete(int id){
        Usuari user = userRepository.findById(id).orElse(null);
        if (user != null)
            userRepository.deleteById(id);
        return user;
    }


}
