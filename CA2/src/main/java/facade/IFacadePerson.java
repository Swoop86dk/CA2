package facade;

import entity.Person;
import entity.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class IFacadePerson
{

    EntityManagerFactory emf;
    
    public IFacadePerson(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public PersonDTO getPersonDTO(Integer id)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            System.out.println(p);
            PersonDTO pdto = new PersonDTO(p);
            //PersonDTO p = new PersonDTO(em.find(Person.class, id));
           // em.getTransaction().commit();
            return pdto;

        }
        finally
        {
            em.close();
        }    
    }
            
//        {
//            Person res = null;
//        List<Person> person;
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Query nquery = em.createNamedQuery("Person.findById", Person.class);
//        person = nquery.getResultList();
//        em.close();
//        for(Person p : person) {
//            res = p;
//        }
//        return res;
//        
    
//    }
//            em.getTransaction().begin();
//            //Person p = em.find(Person.class, id);
//            //PersonDTO pedo = new PersonDTO(p);
//            //Query nquery = em.createNamedQuery("Person.findById");
//            Query qry = em.createQuery("SELECT p FROM Person p WHERE p.id = :" + id);
//            Person person = (Person)qry.getSingleResult();
//            em.getTransaction().commit();
//            return person;
//        }
//        finally
//        {
//            em.close();
//        }    
    
        
    public List<PersonDTO> getAllPersonsDTO()
    {
        List<PersonDTO> per = new ArrayList();
        List<Person> pers;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query nquery = em.createNamedQuery("Person.findAll");
        pers = nquery.getResultList();
        em.close();
        for(Person p : pers) {
            per.add(new PersonDTO(p));
        }
        return per;
    }
    
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();

        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    public Person addPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            System.out.println(p.getPhones());
//            p.addPhones(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public Person deletePerson(int id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }
    
    public Person editPerson(Person pers)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, pers.getId());
            if(p != null)
            {
                p = pers;
                em.merge(p);
                em.getTransaction().commit();
                return p;
            }
        }
        finally
        {
            em.close();
        }  
        
        return null;
    }
}

