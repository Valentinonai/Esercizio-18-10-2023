package org.example;

import com.github.javafaker.Faker;
import org.example.entities.Evento;
import org.example.entities.EventoDAO;
import org.example.entities.JpaUtil;
import org.example.entities.TipoEvento;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        Faker fkr = new Faker();
        EventoDAO evdao = new EventoDAO(em);
        Random rnd = new Random();


        for (int i = 0; i < 20; i++) {
            evdao.save(new Evento(fkr.name().title(), LocalDate.of(rnd.nextInt(2023, 2025), rnd.nextInt(1, 13), rnd.nextInt(1, 29)), fkr.lorem().fixedString(50), rnd.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO, rnd.nextInt(1, 1000)));
        }
        Evento found = evdao.getById(6);
        if (found != null)
            System.out.println(found);
        else System.out.println("Elemento non trovato");


        evdao.delete(5);

        evdao.refresh(3);
        em.close();
        JpaUtil.close();
    }
}
