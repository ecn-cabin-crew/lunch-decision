package ld.web.endpoint;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ld.domain.lunch_group.LunchGroup;

@RequestScoped // TODO: CDI to revisit
@Path("lunch-group")
//@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class LunchGroupEndPoint {

	@GET
	@Path("")
	public Response getLunchGroups() {
		
		
		return null;
	}
	
	@GET
	@Path("{lunchGroupId}")
	public Response getLunchGroup(@PathParam("lunchGroupId") String lunchGroupId) {
		String[] members = {"user1", "user2"};
		LunchGroup lg = new LunchGroup(members);
		
		return Response.ok().entity(lg).build();
	}
	
}
