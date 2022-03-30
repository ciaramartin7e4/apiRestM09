package com.example.apirest.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Usuari {
    @Id
    @GeneratedValue
    int id;
}
