package org.acme.sequence;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.reactive.ResponseStatus;

@Path("v1")
public class SequenceResource {

    @GET
    @ResponseStatus(200)
    @Path("/alticci/{param}")
    public HashMap<String, Long> squenceService(@PathParam("param") int param) {
        // new CacheService().load(param, result);
        HashMap<String, Long> result = new SequenceService().renderResultHashMap(param);
        return result;
    }
}