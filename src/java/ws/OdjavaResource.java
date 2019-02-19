/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Darth Revan
 */
@Path("odjava")
public class OdjavaResource {

    @Context
    private UriInfo context;
    @Context 
    private HttpServletRequest request;


    /**
     * Creates a new instance of OdjavaResource
     */
    public OdjavaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.OdjavaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
         HttpSession session = request.getSession();
         session.invalidate();
    
       return "OK";
    }
    

   
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
