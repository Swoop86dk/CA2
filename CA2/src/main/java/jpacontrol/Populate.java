/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.*;
import facade.IFacadePerson;

import java.util.*;
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
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("puca");
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
        em.close();*/
        populatePeople(25);
        
    }
    private static void populatePeople(int amount){
        IFacadePerson pf = new IFacadePerson( Persistence.createEntityManagerFactory( "puca" ) );
        Random rng = new Random();
        ArrayList<String> fName = new ArrayList( 
        Arrays.asList("Jerry", "James", "Jacob", "Jakob", "Maisie", "Sophie", "Sofie", "Sophia", "Sofia", "Mary", "Sachiko", "Seiji", "Seijo", "Kurosaki", "Charles", "George", "Bruce", "Logan", "Linsey", "Lindsey", "Martin", "Simon", "Stefan", "Caroline", "Karoline", "Jessica", "Michel", "Michelle", "Michael", "Naja", "Maja", "Marie", "Frodo", "Gimli", "Luke", "Gandalf", "Legolas", "Louise", "Louis", "Doug", "Jeremy", "Jamie", "Ove", "Ole", "Karl", "Brian", "Robin", "Clark", "Daenerys"));
        ArrayList<String> lName = new ArrayList( 
        Arrays.asList("Smith", "Jackson", "Jacobsen", "Gregersen", "Hood", "Lannister", "Targeryan", "Stark", "Williams", "Miller", "Wilson", "Brown", "Davis", "Wright", "Lopez", "Hall", "Allen", "Anderson", "Garcia", "Evans", "Edwards", "Parker", "Collins", "Robinson", "Turner", "Harris", "Mitchell", "Nelson", "Baker"));
        ArrayList<String> mail = new ArrayList( 
        Arrays.asList("@gmail.com", "@hotmail.com", "@webmail.com", "@hotmail.dk"));
        ArrayList<Hobby> hobbies = new ArrayList( Arrays.asList(new Hobby("Bathing", "Bathing is great!"), new Hobby("LARP", "DEFEAT THE ORCS!"), new Hobby("Climbing", "Is that an ant or a human??"), new Hobby("Bacon eaters", "Mmm, bacon.."), new Hobby("Fencing", "FIGHT TILL YOUR BLADE BREAKS!!")));

	for(int i = 0; i < amount; i++){
		String getFName = fName.get(rng.nextInt(fName.size()));
		String getLName = lName.get(rng.nextInt(lName.size()));
                int min = 10000000;
                int max = 99999999;
		int phone = rng.nextInt(max - min) + min;
		String email = getFName.substring(0,2) + "." + getLName + mail.get(rng.nextInt(mail.size()));
                Person p = new Person(getFName, getLName, email);
                p.addPhones(new Phone(Integer.toString(phone), "", p));
		pf.addPerson(p);
	
	}
}
}
