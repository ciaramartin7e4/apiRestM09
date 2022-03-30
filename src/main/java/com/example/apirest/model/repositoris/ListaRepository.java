package com.example.apirest.model.repositoris;


import com.example.apirest.model.entitats.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ListaRepository extends JpaRepository<Lista, Integer> {
    @Query("SELECT title FROM Lista WHERE users = :id")
    List<Lista> findListaByByUser_Id(int id);

}
