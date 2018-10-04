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
    
    public PersonDTO getPersonDTO(int id)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            PersonDTO pedo = new PersonDTO(p);
            em.getTransaction().commit();
            return pedo;
        }
        finally
        {
            em.close();
        }    
    }
    
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
          //  em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
    public PersonDTO addPerson(PersonDTO p) {
        
        EntityManager em = emf.createEntityManager();
       
        try
        {
            Person p1 = new Person(p);
            em.getTransaction().begin();
            em.persist(p1);
//            p.addPhones(p);
            em.getTransaction().commit();
            return p;
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

