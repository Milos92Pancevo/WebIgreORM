/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Darth Revan
 */
@javax.ws.rs.ApplicationPath("app")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.IgreResource.class);
        resources.add(ws.KomentariResource.class);
        resources.add(ws.KorisnikResource.class);
        resources.add(ws.LinkResource.class);
        resources.add(ws.LoggeduserResource.class);
        resources.add(ws.LoginResource.class);
        resources.add(ws.OdjavaResource.class);
        resources.add(ws.PlatformeResource.class);
    }
    
}
