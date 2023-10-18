package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "persone")
public class Persona {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private char sesso;


}
