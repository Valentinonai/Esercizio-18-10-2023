package org.example;

import com.github.javafaker.Faker;
import org.example.entities.*;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        Faker fkr = new Faker();
        EventoDAO evdao = new EventoDAO(em);
        Random rnd = new Random();
        LocationDAO locDao = new LocationDAO(em);
        PartecipazioneDAO partDao = new PartecipazioneDAO(em);
        PersonaDAO persDao = new PersonaDAO(em);


        Evento ev1 = new Evento(fkr.name().title(), LocalDate.of(rnd.nextInt(2023, 2025), rnd.nextInt(1, 13), rnd.nextInt(1, 29)), fkr.lorem().fixedString(50), rnd.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO, rnd.nextInt(1, 1000));

        evdao.save(ev1);
        Set<Persona> p = new HashSet<>();
        Persona pers1 = new Persona(fkr.name().firstName(), fkr.name().lastName(), fkr.internet().emailAddress(), LocalDate.now(), rnd.nextInt(0, 2) == 0 ? 'M' : 'F');
        persDao.save(pers1);
        p.add(pers1);
        Location loc1 = new Location(fkr.address().city(), fkr.address().cityName());
        locDao.save(loc1);

        Partecipazione part = new Partecipazione(p, ev1);
        part.setStato(Stato.DA_CONFERMARE);
        partDao.save(part);

        ev1.setLocation(loc1);
        evdao.save(ev1);
        Evento ev2 = new Evento(fkr.name().title(), LocalDate.of(rnd.nextInt(2023, 2025), rnd.nextInt(1, 13), rnd.nextInt(1, 29)), fkr.lorem().fixedString(50), rnd.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO, rnd.nextInt(1, 1000));

        evdao.save(ev2);
        Partecipazione part1 = new Partecipazione(p, ev2);
        part1.setStato(Stato.CONFERMATA);
        partDao.save(part1);

        long x = ev1.getId();

        em.close();
        JpaUtil.close();
    }
}
