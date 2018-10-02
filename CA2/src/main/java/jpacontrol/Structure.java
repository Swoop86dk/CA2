/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Martin
 */
public class Structure
{
    public static void main(String[] args)
    {
        HashMap<String, Object> puproperties = new HashMap<>();  
         
        puproperties.put("javax.persistence.sql-load-script-source", "Script/data.sql");
        Persistence.generateSchema("puca", puproperties);
        
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("puca", puproperties);
        
        Persistence.generateSchema("puca", null);
    }
}
