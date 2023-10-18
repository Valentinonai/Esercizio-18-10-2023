package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "lista_partecipazioni")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    private Stato stato;


}
