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
public class AddressDTO
{
    private Integer id;
    private String street;
    private String additionalInfo;
    
    private List<Cityinfo> cityinfoes = new ArrayList<>();

    public AddressDTO (Address a) {
        this.id = a.getId();
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        
        this.cityinfoes = a.getCityinfoes();
    }

    public Integer getId()
    {
        return id;
    }

    public String getStreet()
    {
        return street;
    }

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }


    public List<Cityinfo> getCityinfoes()
    {
        return cityinfoes;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }


    public void setCityinfoes(List<Cityinfo> cityinfoes)
    {
        this.cityinfoes = cityinfoes;
    }
    
}
