package org.example.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @ManyToMany
    @JoinTable(name = "persona_partecipazione", joinColumns = @JoinColumn(name = "partecipazione"), inverseJoinColumns = @JoinColumn(name = "persona"))
    Set<Persona> persona;
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Set<Persona> persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
    }

    public Partecipazione() {
    }


    public long getId() {
        return id;
    }


    public Set<Persona> getPersona() {
        return persona;
    }

    public void setPersona(Set<Persona> persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
