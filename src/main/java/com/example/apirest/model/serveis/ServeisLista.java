package com.example.apirest.model.serveis;

import com.example.apirest.model.entitats.Lista;
import com.example.apirest.model.repositoris.ListaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeisLista {
    private final ListaRepository listaRepository;

    //llistar tots els ítems
    public List<Lista> get(){
        return listaRepository.findAll();
    }

    //consultar ítem per id
    public Lista getById(int id){
        return listaRepository.findById(id).orElse(null);
    }

    //afegir ítem
    public Lista set(Lista it){
        return listaRepository.save(it);
    }


    //modificar sencer, si existeix el canvia, sino retorna null
//    public Lista modificarLista(Lista it){
//        Lista aux=null;
//        if(listaRepository.existsById(it.getIdList())) aux=listaRepository.save(it);
//        return aux;
//    }

    //eliminar ítem per id
    //si no existeix id retorna null
    public Lista delete(int id){
        Lista res=listaRepository.findById(id).orElse(null);
        if(res!=null) listaRepository.deleteById(id);
        return res;
    }

    /*consultar item por id de usuario*/
    public List<Lista> getListByUserId(int id){
        return listaRepository.findListaByByUser_Id(id);
    }

}
