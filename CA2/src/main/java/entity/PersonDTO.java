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
    private List<PhoneDTO> phones = new ArrayList();
    private List<HobbyDTO> hobbies = new ArrayList();
    private List<AddressDTO> addresses = new ArrayList();

    
    public PersonDTO(Person p) {
        this.id = p.getId();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.getEmail();
        this.phones = new ArrayList(p.getPhones());
        this.hobbies = new ArrayList(p.getHobbies());
        this.addresses = new ArrayList(p.getAddresses());


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



