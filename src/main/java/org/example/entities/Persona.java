package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "partecipazioni_id")
    private List<Partecipazione> lista_partecipazioni;


}
