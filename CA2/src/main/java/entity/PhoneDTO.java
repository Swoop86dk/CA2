/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Martin
 */
public class PhoneDTO
{
    private Integer id;
    private String number;
    private String description;
    private Person person;
    
    public PhoneDTO (Phone ph)
    {
        this.id = ph.getId();
        this.number = ph.getNumber();
        this.description = ph.getDescription();
        this.person = ph.getPerson();
    }

    public Integer getId()
    {
        return id;
    }

    public String getNumber()
    {
        return number;
    }

    public String getDescription()
    {
        return description;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
    
}
