/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class HobbyDTO
{
    private Integer id;
    private String name;
    private String description;
   // private List<Person> persons = new ArrayList<>();

    public HobbyDTO (Hobby h)
    {
        this.id = h.getId();
        this.name = h.getName();
        this.description = h.getDescription();
    //    this.persons = h.getPersons();
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

   /* public List<Person> getPersons()
    {
        return persons;
    }*/

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

  /*  public void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }*/
    
}
