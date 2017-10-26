/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.cabelomasterdsc.model.Cabelereiro;
import com.cabelomasterdsc.model.Endereco;
import com.cabelomasterdsc.model.Gerente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import org.junit.Test;

/**
 *
 * @author Athos
 */
public class TestGerente {

    //@Test
    public void cadastrarGerente() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomaster");
        EntityManager em = emf.createEntityManager();

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Gerente g = new Gerente("Athos", "05825845632", "athos@gmail.com", "123", data.parse("1994-12-04"), 'M',
                    new Endereco("53170280", "rua antorio berenguer", "passarinho", 258, "", "Olinda", "PE"));

            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //@Test
    public void excluirGerente() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomaster");
        EntityManager em = emf.createEntityManager();

        try {
            Gerente g = em.find(Gerente.class, 1);
            em.getTransaction().begin();
            em.remove(g);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            em.close();
        }
    }

    @Test
    public void cadastrarCabelereiro() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancomaster");
        EntityManager em = emf.createEntityManager();

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNascimento = new Date();

        try {
            dtNascimento = data.parse("1993-12-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Gerente g = em.find(Gerente.class, 1);
        
        Cabelereiro c = new Cabelereiro("Alexia", "05825845631", "alexia@gmail.com", "123", dtNascimento, 'F',
                new Endereco("53170280", "rua antorio berenguer", "passarinho", 258, "", "Olinda", "PE"));
        c.setGerente(g);
        
        em.getTransaction().begin();
        g.setCabelereiro(c);
        em.getTransaction().commit();

    }
}
