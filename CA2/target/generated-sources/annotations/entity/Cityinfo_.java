package entity;

import entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T10:37:05")
@StaticMetamodel(Cityinfo.class)
public class Cityinfo_ { 

    public static volatile SingularAttribute<Cityinfo, String> zip;
    public static volatile SingularAttribute<Cityinfo, Address> address;
    public static volatile SingularAttribute<Cityinfo, String> city;
    public static volatile SingularAttribute<Cityinfo, Integer> id;

}