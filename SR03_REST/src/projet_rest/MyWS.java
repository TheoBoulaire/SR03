package projet_rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import projet.sr03.fr.RequestsLocal;



@Stateless
@Path("/req")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class MyWS {
	
	@EJB
	private RequestsLocal req;
	
	/*
	@GET
	@Path("/deleteCouleur")
    public Response deleteCouleur(@QueryParam("cid") int cid)
    {
		return Response.ok(this.req.deleteCouleur(cid)).build();
    }*/
	
	@GET
	@Path("/couleurOfId")
    public Response getCouleurOfId(@QueryParam("cid") Integer cid)
    {
		return Response.ok(this.req.getCouleurOfId(cid)).build();
    }
	//http://localhost:8080/projet/req/couleurOfId?cid=1
	
	@GET
	@Path("/countMotorisations")
    public Response countMotorisation()
    {
		return Response.ok(this.req.countMotorisations()).build();
    }
	//http://localhost:8080/projet/req/countMotorisations
	
	@GET
	@Path("/optionSupOfVoiture")
    public Response getOptionSupOfVoiture(@QueryParam("vid") Integer vid)
    {
		return Response.ok(this.req.getOptionSupForVoiture(vid)).build();
    }
	//http://localhost:8080/projet/req/optionSupOfVoiture?vid=1
	
	@GET
	@Path("/couleurOfVoiture")
    public Response getCouleurOfVoiture(@QueryParam("vid") Integer vid)
    {
		return Response.ok(this.req.getCouleurOfVoiture(vid)).build();
    }
	//http://localhost:8080/projet/req/couleurOfVoiture?vid=1
	
	@GET
	@Path("/motorisations")
    public Response getMotorisation()
    {
		return Response.ok(this.req.getMotorisations()).build();
    }
	//http://localhost:8080/projet/req/motorisations
	
	@GET
	@Path("/couleurs")
    public Response getCouleur()
    {
		return Response.ok(this.req.getCouleurs()).build();
    }
	//http://localhost:8080/projet/req/couleurs
	
	/*
	@GET
	@Path("/motorisations")
    public Response getMotorisation()
    {
		return Response.ok(this.req.getMotorisations()).build();
    }
	
	@GET
	@Path("/moteur")
    public Response getMotorisationByFinition(@QueryParam("fid") int fid)
    {
		return Response.ok(this.req.getMotorisationsByFinitions(fid)).build();
    }
    */
}