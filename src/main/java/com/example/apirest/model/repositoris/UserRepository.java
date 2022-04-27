package com.example.apirest.model.repositoris;

import com.example.apirest.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Usuari, Integer> {
    Optional<Usuari> findByUsername(String username);

}
