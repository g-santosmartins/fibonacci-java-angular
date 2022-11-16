package org.acme.sequence;

import java.util.HashMap;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.reactive.ResponseStatus;

import io.quarkus.cache.Cache;
import io.quarkus.cache.CacheName;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;

@Path("v1")
public class SequenceResource {

    @Inject 
    @CacheName("sequence-cache")
    Cache cache;

    @GET
    @Path("/alticci/{param}")
    @ResponseStatus(200)
    @NonBlocking

    public Uni<Object> squenceService(@PathParam("param") int param) {
        // Executes only if there's not key related in cache
        return cache.get(param, k -> { 
            HashMap<String, Long> result = new SequenceService().renderResultHashMap(param);
            return result;
        });
    }
}