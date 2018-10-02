/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class Populate
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puca");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Person p = new Person(4, "Hugo", "Weaving", "Elverland@frodo.dk");
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
}
