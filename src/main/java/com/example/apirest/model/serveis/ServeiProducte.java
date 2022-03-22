package com.example.apirest.model.serveis;

import com.example.apirest.model.entitats.Producte;
import com.example.apirest.model.repositoris.RepositoriProducte;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeiProducte {
    private final RepositoriProducte repositoriProducte;
    //llistar tots els ítems
    public List<Producte> get(){
        return repositoriProducte.findAll();
    }
    //consultar ítem per id
    public Producte getById(int id){
        return repositoriProducte.findById(id).orElse(null);
    }
    //afegir producte
    public Producte set(Producte it){
        return repositoriProducte.save(it);
    }
    //si no existeix id retorna null
    public Producte delete(int id){
        Producte res=repositoriProducte.findById(id).orElse(null);
        if(res!=null) repositoriProducte.deleteById(id);
        return res;
    }

    /*consultar item por id de usuario*/
    public List<Producte> getListByPrice(double price){
        return repositoriProducte.findByPrice(price);
    }



}
