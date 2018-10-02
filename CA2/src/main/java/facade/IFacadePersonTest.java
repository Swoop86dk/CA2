/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import facade.IFacadePerson;
import javax.persistence.Persistence;

/**
 * TESTS VIRKER!
 * @author Martin
 */
public class IFacadePersonTest
{
    public static void main(String[] args)
    {
        IFacadePerson pf = new IFacadePerson( Persistence.createEntityManagerFactory( "puca" ) );
        
        System.out.println("GetPerson : " + pf.getPerson(1).getFirstName());
        
        System.out.println("GetPersons : " + pf.getPersons());
        
    //    System.out.println("AddPerson : " + pf.addPerson(new Person("Simon", "Wall", "5554637")));
        
        System.out.println("DeletePerson : " + pf.deletePerson(1));
        
        Person p = pf.getPerson(2);
        p.setFirstName("Alan");
        System.out.println("EditPerson : " + pf.editPerson(p));
        
        System.out.println("GetPersons : " + pf.getPersons() );
    }
}
