package com.example.apirest.controladors;

import com.example.apirest.model.entitats.Lista;
import com.example.apirest.model.entitats.Task;
import com.example.apirest.model.entitats.Usuari;
import com.example.apirest.model.serveis.ServeisItem;
import com.example.apirest.model.serveis.ServeisLista;
import com.example.apirest.model.serveis.ServeisUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controlador {

    private final ServeisItem serveisItem;
    private final ServeisLista serveisLista;
    private final ServeisUser serveisUser;


    //USER
    @GetMapping("/usuaris")
    public List<Usuari> getUsers() {
        return serveisUser.get();
    }
    @GetMapping("/usuaris/{id}")
    public ResponseEntity<Usuari> consultarUsuari(@PathVariable Integer id) {
        Usuari user = serveisUser.getById(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }
    @PostMapping("/usuaris")
    public ResponseEntity<Usuari> postUser(@RequestBody Usuari user) {
        Usuari u = serveisUser.set(user);
        return new ResponseEntity<Usuari>(u, HttpStatus.CREATED);
    }
    @PutMapping("/usuaris")
    public ResponseEntity<Usuari> updateUser(@RequestBody Usuari user) {
        Usuari u = serveisUser.set(user);
        return ResponseEntity.ok(u);
    }
    @DeleteMapping("/usuaris/{id}")
    public Usuari deleteUser(@PathVariable int id) {
        return serveisUser.delete(id);
    }

    //LLISTA
    @GetMapping("/listas")
    public ResponseEntity<List<Lista>> getLists() {
        return ResponseEntity.ok(serveisLista.get());
    }
    @GetMapping("/listas/{id}")
    public ResponseEntity<Lista> getListsById(@PathVariable int id){
        Lista lista = serveisLista.getById(id);
        if(lista == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/listas")
    public ResponseEntity<Lista> postLista(@RequestBody Lista lista){
        Lista l = serveisLista.set(lista);
        return new ResponseEntity<Lista>(l, HttpStatus.CREATED);
    }
    @PutMapping("/listas")
    public ResponseEntity<Lista> updateLista(@RequestBody Lista lista) {
        Lista l = serveisLista.set(lista);
        return ResponseEntity.ok(l);
    }
    @DeleteMapping("/listas/{id}")
    public ResponseEntity<Integer> deleteList(@PathVariable int id) {
        serveisLista.delete(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/lista/user/{id}")
    public ResponseEntity<List<Lista>> getListByUserId(@PathVariable int id) {
        List<Lista> lista = serveisLista.getListByUserId(id);
        return ResponseEntity.ok(lista);
    }

    //ITEM
    @GetMapping ("/tareas")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(serveisItem.get());
    }
    @GetMapping("/tareas/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        Task t = serveisItem.getById(id);
        if (t == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(t);
    }
    @PostMapping("/tareas")
    public ResponseEntity<Task> postTask (@RequestBody Task task){
        Task t = serveisItem.set(task);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }
    @PutMapping("/tareas")
    public ResponseEntity<Task> putTask (@RequestBody Task task) {
        Task t = serveisItem.set(task);
        return ResponseEntity.ok(t);
    }
    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<Integer> deleteTask (@PathVariable int id){
        serveisItem.delete(id);
        return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
    }
}
