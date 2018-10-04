/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.*;
import facade.AddressFacade;
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
        populateAddresses(1);
        //populatePeople(25);
        
    }
    private static ArrayList<Address> addresses = new ArrayList();
    private static ArrayList<Address> tempAddress = new ArrayList(Arrays.asList(new Address("Lærkevej", ""), new Address("Birkevej", ""), new Address("Vibevej", ""), new Address("Vinkelvej", ""), new Address("Østergade", ""), new Address("Engvej", ""), new Address("Kirkevej", "")));
    
    
    private static void populateAddresses(int amount){
        Random rng = new Random();
        AddressFacade af = new AddressFacade();
        Address tmpAddress = tempAddress.get(rng.nextInt(tempAddress.size()));
        tmpAddress.setCityinfo(af.getCity(rng.nextInt(1000)+1));
        //addresses.add(tmpAddress);
        System.out.println(tmpAddress);
    }
    private static void populatePeople(int amount){
        IFacadePerson pf = new IFacadePerson( Persistence.createEntityManagerFactory( "puca" ) );
        AddressFacade af = new AddressFacade();
        Random rng = new Random();
        ArrayList<String> fName = new ArrayList( 
        Arrays.asList("Jerry", "James", "Jacob", "Jakob", "Maisie", "Sophie", "Sofie", "Sophia", "Sofia", "Mary", "Sachiko", "Seiji", "Seijo", "Kurosaki", "Charles", "George", "Bruce", "Logan", "Linsey", "Lindsey", "Martin", "Simon", "Stefan", "Caroline", "Karoline", "Jessica", "Michel", "Michelle", "Michael", "Naja", "Maja", "Marie", "Frodo", "Gimli", "Luke", "Gandalf", "Legolas", "Louise", "Louis", "Doug", "Jeremy", "Jamie", "Ove", "Ole", "Karl", "Brian", "Robin", "Clark", "Daenerys"));
        ArrayList<String> lName = new ArrayList( 
        Arrays.asList("Smith", "Jackson", "Jacobsen", "Gregersen", "Hood", "Lannister", "Targeryan", "Stark", "Williams", "Miller", "Wilson", "Brown", "Davis", "Wright", "Lopez", "Hall", "Allen", "Anderson", "Garcia", "Evans", "Edwards", "Parker", "Collins", "Robinson", "Turner", "Harris", "Mitchell", "Nelson", "Baker"));
        ArrayList<String> mail = new ArrayList( 
        Arrays.asList("@gmail.com", "@hotmail.com", "@webmail.com", "@hotmail.dk"));
        ArrayList<Hobby> hobbies = new ArrayList( Arrays.asList(new Hobby("Bathing", "Bathing is great!"), new Hobby("LARP", "DEFEAT THE ORCS!"), new Hobby("Climbing", "Is that an ant or a human??"), new Hobby("Bacon eaters", "Mmm, bacon.."), new Hobby("Fencing", "FIGHT TILL YOUR BLADE BREAKS!!")));
        ArrayList<Cityinfo> cities = af.getAllCities();
	for(int i = 0; i < amount; i++){
		String getFName = fName.get(rng.nextInt(fName.size()));
		String getLName = lName.get(rng.nextInt(lName.size()));
                int min = 10000000;
                int max = 99999999;
		int phone = rng.nextInt(max - min) + min;
		String email = getFName.substring(0,2) + "." + getLName + mail.get(rng.nextInt(mail.size()));
                Address address ;
                Person p = new Person(getFName, getLName, email);
                p.addPhones(new Phone(Integer.toString(phone), "", p));
		pf.addPerson(p);
	
	}
}
}
