/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author Darth Revan
 */
@Path("platforme")
public class PlatformeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlatformeResource
     */
    public PlatformeResource() {
    }

    /**
     * Retrieves representation of an instance of ws.PlatformeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String platforma() {
        
        List<Object[]> ress = DB.query("SELECT i.igrNaziv"
                + "FROM Igra i JOIN Platforma p ON i.igrId.igrId = p.igrId "); 
        JSONArray a = new JSONArray();
        for(Object[] p: ress){
            JSONObject obj = new JSONObject();
            String naziv = p[0] + "";

            obj.put("naziv",naziv); 

            a.put(obj);    
        }
        return a.toString();
       
    }
}

   