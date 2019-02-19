/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Eksternilink;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
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
@Path("link")
public class LinkResource {

    @Context
    private UriInfo context;

    @Context
    private HttpServletRequest request;

    /**
     * Creates a new instance of LinkResource
     */
    public LinkResource() {
    }

    /**
     * Retrieves representation of an instance of ws.LinkResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String link() {
        
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute("user")!=null) {
        
        List<Eksternilink> res = DB.query("SELECT e FROM Eksternilink e");
        JSONArray a = new JSONArray();
        for (Eksternilink e : res) {
            JSONObject obj = new JSONObject();
            obj.put("naziv", e.getIgrId().getIgrNaziv());
            obj.put("link", e.getEklUrl());
            obj.put("vrsta", e.getVrsId().getVrsNaziv());

            a.put(obj);
           }
            return a.toString();
        } else {
            return "ERR";
        }
    }
}
    /**
     *@POST @Path("dodaj")
      @Consumes(MediaType.APPLICATION_JSON) public void dodaj(String content) {
      HttpSession session = request.getSession(); if (session == null ||
      session.getAttribute("user") == null) return;
     
      JSONObject obj = new JSONObject(content); String naziv =
      obj.getString("link"); Eksternilink e = new Eksternilink();
      e.setEklUrl(naziv); DB.insert(e);
     
      }
     */

