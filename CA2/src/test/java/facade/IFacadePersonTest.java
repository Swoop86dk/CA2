/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martin
 */
public class IFacadePersonTest
{
    
    public IFacadePersonTest()
    {
        
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getPerson method, of class IFacadePerson.
     */
//    @Test
//    public void testGetPerson()
//    {
//        System.out.println("getPerson");
//        int id = 0;
//        IFacadePerson instance = null;
//        Person expResult = null;
//        Person result = instance.getPerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersons method, of class IFacadePerson.
//     */
//    @Test
//    public void testGetPersons()
//    {
//        System.out.println("getPersons");
//        IFacadePerson instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addPerson method, of class IFacadePerson.
//     */
//    @Test
//    public void testAddPerson()
//    {
//        System.out.println("addPerson");
//        Person p = null;
//        IFacadePerson instance = null;
//        Person expResult = null;
//        Person result = instance.addPerson(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePerson method, of class IFacadePerson.
//     */
//    @Test
//    public void testDeletePerson()
//    {
//        System.out.println("deletePerson");
//        int id = 0;
//        IFacadePerson instance = null;
//        Person expResult = null;
//        Person result = instance.deletePerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of editPerson method, of class IFacadePerson.
//     */
//    @Test
//    public void testEditPerson()
//    {
//        System.out.println("editPerson");
//        Person pers = null;
//        IFacadePerson instance = null;
//        Person expResult = null;
//        Person result = instance.editPerson(pers);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    public static void main(String[] args)
    {
        IFacadePerson pf = new IFacadePerson( Persistence.createEntityManagerFactory( "puca" ) );
        System.out.println("GetPerson : " + pf.getPersonDTO(1).getFirstName());
        
        System.out.println("GetPersons : " + pf.getPersons());
        
        System.out.println("AddPerson : " + pf.addPerson(new Person(3,"Simon", "Wall", "5554637@mail.dk")));
        
        System.out.println("DeletePerson : " + pf.deletePerson(1));
        
        //Person p = pf.getPerson(2);
       // p.setFirstName("Alan");
       // System.out.println("EditPerson : " + pf.editPerson(p));
        
        System.out.println("GetPersons : " + pf.getPersons() );
    }
}
