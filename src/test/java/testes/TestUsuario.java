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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Athos
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SuppressWarnings("JPQLValidation")
public class TestUsuario {

    private static EntityManagerFactory emf;
    //private static Logger logger;
    private EntityManager em;
    private EntityTransaction et;
    
    @BeforeClass
    public static void setUpClass(){
        emf = Persistence.createEntityManagerFactory("bancomaster");
        //logger.setLevel(Level.SEVERE);
        DbUnitUtil.inserirDados();
    }
    
    @AfterClass
    public static void tearDownClass(){
        emf.close();
    }
    
    @Before
    public void setUp(){
        em = emf.createEntityManager();
        beginTransaction();
    }

    @After
    public void tearDown(){
        commitTransaction();
        em.close();
    }
    
    private void beginTransaction(){
        et = em.getTransaction();
        et.begin();
    }
    
    private void commitTransaction(){
        try {
            et.commit();
        } catch (Exception e) {
            //logger.log(Level.SEVERE, e.getMessage(), e);
            et.rollback();
            Assert.fail(e.getMessage());
        }
    }
    
    @Test
    public void cadastrarGerente() {

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Gerente g = null;
        try {
            g = new Gerente("Maria", "058.258.456-32", "maria@gmail.com", "123", data.parse("1993-05-08"), 'F',
                    new Endereco("53170280", "rua antorio berenguer", "passarinho", 258, "", "Olinda", "PE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        em.persist(g);
    }

    //@Test
    public void excluirGerente() {
        
            Gerente g = em.find(Gerente.class, 1);

            em.remove(g);

    }

    //@Test
    public void cadastrarCabelereiro() {

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date dtNascimento = new Date();

        try {
            dtNascimento = data.parse("1993-12-04");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Gerente g = em.find(Gerente.class, 1);
        
        Cabelereiro c = new Cabelereiro("Marcos", "057.258.456-31", "marcos@gmail.com", "123", dtNascimento, 'M',
                new Endereco("53170280", "rua antorio berenguer", "passarinho", 258, "", "Olinda", "PE"));
        c.setGerente(g);
        
        g.setCabelereiro(c);
    }
}
