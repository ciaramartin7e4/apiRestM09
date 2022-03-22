package com.example.apirest.model.repositoris;

import com.example.apirest.model.entitats.Producte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoriProducte extends JpaRepository<Producte, Integer> {
    @Query("SELECT name FROM Producte WHERE price = :price")
    List<Producte> findByPrice(double price);

}
