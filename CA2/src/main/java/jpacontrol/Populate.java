/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.Address;
import entity.Cityinfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
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
        Person p = new Person(1, "Hugo", "Weaving", "Elverland@frodo.dk");
        em.persist(p);
        System.out.println(p.toString());
        Person p1 = new Person(2,"Lars", "Bobo", "Elverland@frodo.dk");
        em.persist(p1);
        Phone ph = new Phone(1, "12345678", "Skide godt nummer ");
        p.addPhones(ph);
        ph.setPerson(p);
        em.persist(ph);
        System.out.println(ph.toString());
        List<Person> q = new ArrayList<>();
        Hobby h = new Hobby(1, "Bademester", "Svømmer ikke så godt", q);
        p.addHobbies(h);
        System.out.println(h.getPersons() + p.toString());
        h.addPerson(p);
        em.persist(h);  
        Address a = new Address(1, "Yellow Road 1", "Berlin");
        p.addAddress(a);
        a.setPerson(p);
        em.persist(a);
        
        Cityinfo c = new Cityinfo(1, "2605", "Brøndby aka VestEgn");
        a.addCityinfo(c);
        c.setAddress(a);
        em.persist(c);  
        
        em.getTransaction().commit();
        em.close();
        
    }
}
