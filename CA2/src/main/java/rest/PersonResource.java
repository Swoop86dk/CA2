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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
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
        // Simple method to test use of Path annotation. Test with /api/Person/allasmap
    @GET
    @Path("/allasmap")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersons() {
        return Response.ok().entity(gson.toJson(pf.getAllPersonsDTO())).build();
    }
    
    // Simple method to use with javascript (See the script.js file. (THIS PART ISNT DONE YET!)
    // Test with /api/Person/allasarray Better for javascript to get an array of objects
    @GET
    @Path("/allasarray")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllasArray() {
        return Response.ok().entity(gson.toJson(pf.getPersons())).build();
    }
    
        // Method to test the use of semantic parameters. Test with /api/Person/3
    @GET
    @Path("/{id}") //with a sematic url parameter
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonByID(@PathParam("id") int id) {
        return Response.ok().entity(gson.toJson(pf.getPerson(id))).build();
    }
        // Method to test use of request parameters from a web form. Test with POST: /api/Person/ DATA: {  "firstName": "TestFname1","lastName": "TestLname2","email": "TestPerson@hotmail.dk","phones": [],"hobbies": [],"addresses": []}
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response postPerson(String content) {
//        Person newPerson = gson.fromJson(content, Customer.class);
//        System.out.println("newCustomer: " + newCustomer);
//        addCustomer(newCustomer);
//        return Response.ok().entity(gson.toJson(newCustomer)).build();
//    }

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
