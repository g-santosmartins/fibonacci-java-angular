package org.acme.sequence;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("v1")
public class SequenceResource {

    @GET
    @Path("/alticci/{param}")
    public HashMap<String, Long> squenceService(@PathParam("param") int param) {
        // new CacheService().load(param, result);
        HashMap<String, Long> result = new SequenceService().renderResultHashMap(param);
        return result;
    }
}