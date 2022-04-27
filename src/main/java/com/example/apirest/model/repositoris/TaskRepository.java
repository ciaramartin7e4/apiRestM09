package com.example.apirest.model.repositoris;

import com.example.apirest.model.entitats.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> { }
