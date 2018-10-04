/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Cityinfo;
import entity.Person;
import entity.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Tarllark
 */
public class AddressFacade {
    
    
     public ArrayList<Cityinfo> getAllCities()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "puca" );
        ArrayList<Cityinfo> res = new ArrayList();
        List<Cityinfo> cities;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query nquery = em.createNamedQuery("Cityinfo.findAll");
        cities = nquery.getResultList();
        em.close();
        for(Cityinfo c : cities) {
            res.add(c);
        }
        return res;
    }
     public Cityinfo getCity(int id)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "puca" );
        Cityinfo res = null;
        List<Cityinfo> cities;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query nquery = em.createNamedQuery("Cityinfo.findById");
        cities = nquery.getResultList();
        em.close();
        for(Cityinfo c : cities) {
            res = c;
        }
        return res;
    }
}
