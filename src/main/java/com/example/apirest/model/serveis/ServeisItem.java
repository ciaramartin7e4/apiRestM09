package com.example.apirest.model.serveis;

import com.example.apirest.model.entitats.Task;
import com.example.apirest.model.repositoris.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServeisItem {

    private final TaskRepository taskRepository;


    //llistar tots els ítems
    public List<Task> get(){
        return taskRepository.findAll();
    }

    //consultar ítem per id
    public Task getById(int id){
        return taskRepository.findById(id).orElse(null);
    }

    //afegir ítem
    public Task set(Task it){
        return taskRepository.save(it);
    }




    //modificar sencer, si existeix el canvia, sino retorna null
//    public Task modificarTaska(Task it){
//        Task aux=null;
//        if(taskRepository.existsById(it.getIdTask())) aux=taskRepository.save(it);
//        return aux;
//    }

    //eliminar ítem per id
    //si no existeix id retorna null
    public Task delete(int id){
        Task res=taskRepository.findById(id).orElse(null);
        if(res!=null) taskRepository.deleteById(id);
        return res;
    }

}
