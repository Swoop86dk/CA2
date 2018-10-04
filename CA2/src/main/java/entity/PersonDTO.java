package entity;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<PhoneDTO> phones = new ArrayList();
    private List<HobbyDTO> hobbies = new ArrayList();
    private List<AddressDTO> addresses = new ArrayList();

    
    public PersonDTO(Person p) {
        System.out.println(p);
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        for(Phone Ph : p.getPhones()){
            this.phones.add(new PhoneDTO(Ph));
        }
        this.hobbies = new ArrayList();
        for(Hobby h : p.getHobbies()){
            this.hobbies.add(new HobbyDTO(h));
        }
        
        this.addresses = new ArrayList();
        for(Address a : p.getAddresses()){
            this.addresses.add(new AddressDTO(a));
        }
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

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public List<AddressDTO> getAddresses() {
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

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    
    
    
    
    
}



