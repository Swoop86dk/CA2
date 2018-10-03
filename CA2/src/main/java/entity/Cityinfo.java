/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "cityinfo")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Cityinfo.findAll", query = "SELECT c FROM Cityinfo c")
    , @NamedQuery(name = "Cityinfo.findById", query = "SELECT c FROM Cityinfo c WHERE c.id = :id")
    , @NamedQuery(name = "Cityinfo.findByZipcode", query = "SELECT c FROM Cityinfo c WHERE c.zipcode = :zipcode")
    , @NamedQuery(name = "Cityinfo.findByCity", query = "SELECT c FROM Cityinfo c WHERE c.city = :city")
})
public class Cityinfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;

    public Cityinfo()
    {
    }

    public Cityinfo(Integer id)
    {
        this.id = id;
    }

    public Cityinfo(Integer id, String zipcode, String city)
    {
        this.id = id;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cityinfo))
        {
            return false;
        }
        Cityinfo other = (Cityinfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Cityinfo[ id=" + id + " ]";
    }
    
}