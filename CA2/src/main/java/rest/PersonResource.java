/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.IFacadePerson;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("Person")
public class PersonResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource()
    {
    }
    IFacadePerson pf = new IFacadePerson(Persistence.createEntityManagerFactory("puca"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    @PersistenceContext(unitName = "puca")
//    private EntityManager em;

    // Simple method to see if the service is running. Test with: /api/Person
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson()
    {
        //return Response.ok().entity(new String("ok")).build();
        return Response.ok().entity(gson.toJson(pf.getPerson(1))).build();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content)
    {
    }
}
