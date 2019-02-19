/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Igra;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author Darth Revan
 */
@Path("igre")
public class IgreResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IgreResource
     */
    public IgreResource() {
    }

    /**
     * Retrieves representation of an instance of ws.IgreResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String pokreniIgru() {
        List<Igra> res = DB.query("SELECT i FROM Igra i");
        JSONArray a = new JSONArray();
        for (Igra i : res) {
            JSONObject obj = new JSONObject();
            obj.put("naziv", i.getIgrNaziv());
            obj.put("datum", i.getIgrDatum());
            obj.put("opis", i.getIgrOpis());
            obj.put("zanr", i.getZnrId().getZnrNaziv());
            obj.put("izdavac", i.getIzdId().getIzdNaziv());
            a.put(obj);
        }

        return a.toString();

    }

}
/**
 * PUT method for updating or creating an instance of IgreResource
 *
 * @param content representation for the resource
 */
