package com.example.apirest.model.repositoris;

import com.example.apirest.model.entitats.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Usuari, Integer> {
}
