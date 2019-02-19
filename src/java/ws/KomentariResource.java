/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import db.DB;
import db.Igra;
import db.Komentar;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author Darth Revan
 */
@Path("komentari")
public class KomentariResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KomentariResource
     */
    public KomentariResource() {
    }

    /**
     * Retrieves representation of an instance of ws.KomentariResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public void komentar(String content) {
        JSONObject obj = new JSONObject(content);
        String naziv = obj.getString("naziv");
        Komentar k = new Komentar();
        k.setKomText(naziv);
        DB.insert(k);
    }
}

/**
 * PUT method for updating or creating an instance of KomentariResource
 *
 * @param content representation for the resource
 */
