package com.example.apirest.controladors;

import com.example.apirest.model.entitats.Producte;
import com.example.apirest.model.serveis.ServeiProducte;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorProducte {
    ServeiProducte serveiProducte;

    // PRODUCTE
    @GetMapping("/productes")
    public ResponseEntity<List<Producte>> getProductes() {
        return ResponseEntity.ok(serveiProducte.get());
    }
    @GetMapping("/productes/{id}")
    public ResponseEntity<Producte> getProductById(@PathVariable int id){
        Producte producte = serveiProducte.getById(id);
        if(producte == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(producte);
    }
    @PostMapping("/productes")
    public ResponseEntity<Producte> postProducte(@RequestBody Producte producte){
        Producte p = serveiProducte.set(producte);
        return new ResponseEntity<Producte>(p, HttpStatus.CREATED);
    }
    @PutMapping("/productes")
    public ResponseEntity<Producte> updateProducte(@RequestBody Producte producte) {
        Producte p = serveiProducte.set(producte);
        return ResponseEntity.ok(p);
    }
    @DeleteMapping("/productes/{id}")
    public ResponseEntity<Integer> deleteProducte(@PathVariable int id) {
        serveiProducte.delete(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/productes/price/{price}")
    public ResponseEntity<List<Producte>> getProducteByPrice(@PathVariable double price) {
        List<Producte> Producte = serveiProducte.getListByPrice(price);
        return ResponseEntity.ok(Producte);
    }


}
