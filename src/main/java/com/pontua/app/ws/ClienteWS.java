package com.pontua.app.ws;

import controle.ClienteC;
import io.swagger.annotations.Api;
import io.swagger.jaxrs.config.BeanConfig;
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

@Api
@Path("/cliente")
public class ClienteWS extends Application {

    @Context
    private UriInfo context;

    
    public ClienteWS() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("Clientes");
        conf.setDescription("web service de clientes");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8080");
        conf.setBasePath("/mavenWSProjeto/webresources/cliente");
        conf.setSchemes(new String[] { "http" });
        conf.setScan(true);
    }
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "200 OK";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/ler")
    public String getClientes(){
        ClienteC cc = new ClienteC();
        return cc.getClientes();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/criar")
    public boolean postClientes(String cliente){
        ClienteC cc = new ClienteC();
        return cc.postClientes(cliente);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/deletar/{id}")
    public boolean deleteClientes(@PathParam("id") int id){
        ClienteC cc = new ClienteC();
        return cc.deleteCliente(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/atualizar")
    public boolean atualizarClientes(String cliente){
        ClienteC cc = new ClienteC();
        return cc.atualizarCliente(cliente);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("pontua/login")
    public String loginCliente(String cliente){
        ClienteC cc = new ClienteC();
        return cc.loginCliente(cliente);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/buscar/{id}")
    public String buscaCliente(@PathParam("id") int id){
        ClienteC cc = new ClienteC();
        return cc.buscaCliente(id);
    }

    /**
     * PUT method for updating or creating an instance of ClienteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
}
