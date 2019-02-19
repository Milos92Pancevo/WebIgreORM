/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Korisnik;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author Darth Revan
 */
@Path("korisnik")
public class KorisnikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KorisnikResource
     */
    public KorisnikResource() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public String dodajKorisnika(String conntent) {
        JSONObject obj = new JSONObject(conntent);
        String ime = obj.getString("ime");
        String prezime = obj.getString("prezime");
        String email = obj.getString("email");
        String sifra = obj.getString("sifra");
        
        Korisnik k = new Korisnik();
        k.setKorIme(ime);
        k.setKorPrezime(prezime);
        k.setKorEmail(email);
        k.setKorPass(sifra);
        k.setKogRegistrovan(new Date());
        
        DB.insert(k);
        JSONObject res = new JSONObject();
        res.put("res", "OK");
        return res.toString();
    }
    
    
    @POST
    @Path("iskoriscen")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String proveri(String content) {
        JSONObject obj=new JSONObject(content);
        String email=obj.getString("email");
        List <Korisnik> korisnik = DB.query("Select k from Korisnik k WHERE k.korEmail=?1", email);
        JSONObject res=new JSONObject();
            if (korisnik.size()==0)
        res.put("res", "OK");
            else 
        res.put("res", "ERR");
        return res.toString();
    }
    

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
