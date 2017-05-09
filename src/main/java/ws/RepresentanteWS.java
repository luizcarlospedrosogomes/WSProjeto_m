package ws;

import controle.RepresentanteC;
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

@Path("representante")
public class RepresentanteWS extends Application {

    @Context
    private UriInfo context;

    
    public RepresentanteWS() {
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "ok";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/tst")
    public String getTst(){
        return "testado";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/ler")
    public String getRepresentante(){
        RepresentanteC rc = new RepresentanteC();
        return rc.getRepresentantes();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/criar")
    public boolean postRepresentante(String representante){
        RepresentanteC rc = new RepresentanteC();
        return rc.postRepresentantes(representante);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/deletar/{id}")
    public boolean deleteRepresentante(@PathParam("id") int id){
        RepresentanteC rc = new RepresentanteC();
        return rc.deleteRepresentante(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/atualizar")
    public boolean atualizarRepresentante(String representante){
        RepresentanteC rc = new RepresentanteC();
        return rc.atualizarRepresentante(representante);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON) //consome um json
    @Path("/login/")
    public String loginRepresentante(String representante){
        RepresentanteC rc = new RepresentanteC();
        return rc.loginRepresentante(representante);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON) //produz um json
    @Path("/buscar/{id}")
    public String buscaRepresentante(@PathParam("id") int id){
        RepresentanteC rc = new RepresentanteC();
        return rc.buscaRepresentante(id);
    }

    /**
     * PUT method for updating or creating an instance of RepresentnteWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
