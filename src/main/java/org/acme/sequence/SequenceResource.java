package org.acme.sequence;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("v1")
public class SequenceResource {
    @GET
    @Path("/alticci/{param}")
    // @Produces(MediaType.APPLICATION_JSON)
    public Long squenceService(@PathParam("param") int param) {
        long result = new SequenceService().produceSequence(param);
        return result; 
    }
}