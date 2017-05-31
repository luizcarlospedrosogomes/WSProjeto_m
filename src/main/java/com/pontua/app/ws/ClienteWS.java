
package com.pontua.app.ws;

import controle.ClienteC;

import java.io.UnsupportedEncodingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ClienteWS extends Application {

    @Context
    private UriInfo context;

    
    public ClienteWS() {
       /* BeanConfig conf = new BeanConfig();
        conf.setTitle("Clientes");
        conf.setDescription("web service de clientes");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/pontua");
        conf.setSchemes(new String[] { "http" });
        conf.setScan(true);*/
    }
            
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("login")
    public Response loginCliente(String cliente) throws IllegalArgumentException, UnsupportedEncodingException{
        System.out.println("DADOS RECEBIDO: " +cliente);
    	ClienteC cc = new ClienteC();
    	
    	if (!cc.loginCliente(cliente).isEmpty()){
    		return Response.ok("TOKENPARALOGIN").build();
    	}
    	return Response.status(401).build();
    }
    
    
    
}

