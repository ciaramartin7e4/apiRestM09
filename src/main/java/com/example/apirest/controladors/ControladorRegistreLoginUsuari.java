package com.example.apirest.controladors;

import com.example.apirest.model.entitats.Usuari;
import com.example.apirest.model.entitats.UsuariConsultaDTO;
import com.example.apirest.model.serveis.ServeisUser;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorRegistreLoginUsuari {
    private final ServeisUser serveiUsuaris;


    @GetMapping("/me")
    public UsuariConsultaDTO consultaQuiEts(@AuthenticationPrincipal Usuari usu) {
        return new UsuariConsultaDTO(usu.getUsername(), usu.getAvatar(), usu.getRol());
    }

    /*
    {
    "username":"Montse",
    "password":"1234",
    "avatar":"http://imatge.com"
    }
    Afegeix id automàticament
     */
//    @PostMapping("/usuaris")
    @RequestMapping(path = "/usuarisNou", method = RequestMethod.POST)
    public ResponseEntity<?> nouUsuari(@RequestBody Usuari nouUsuari) {
        try {
            Usuari res = serveiUsuaris.crearNouUsuari(nouUsuari);
            UsuariConsultaDTO usu = new UsuariConsultaDTO(res.getUsername(), res.getAvatar(), res.getRol());
            return new ResponseEntity<UsuariConsultaDTO>(usu, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException ex) {
            //per si intentem afegir 2 usuaris amb el mateix username, saltarà excepció
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

//    @GetMapping("/usuaris")
    @RequestMapping(value = "/usuarisList", method = RequestMethod.GET)
    public ResponseEntity<?> llistarUsuarisDTO() {
        List<Usuari> res = serveiUsuaris.get();
        List<UsuariConsultaDTO> aux = new ArrayList();
        for (Usuari usu : res) {
            aux.add(new UsuariConsultaDTO(usu.getUsername(), usu.getAvatar(), usu.getRol()));
        }
        if (res.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(aux);
    }
}
