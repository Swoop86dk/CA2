package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simon
 */
public class PersonDTO {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Phone> phones = new ArrayList();
    private List<Hobby> hobbies = new ArrayList();
    private List<Address> addresses = new ArrayList();

    
    public PersonDTO(Person p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        this.phones = p.getPhones();
        this.hobbies = p.getHobbies();
        this.addresses = p.getAddresses();


    }

    

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    
    
    
    
    
}



