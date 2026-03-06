package com.example;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Controller demonstrating the nested layout pattern that triggers
 * a false positive in the Qute language server.
 *
 * @see <a href="https://github.com/redhat-developer/intellij-quarkus/issues/1557">Issue #1557</a>
 */
@Path("/")
public class FeatureController {

    @GET
    public Response index() {
        return Response.seeOther(java.net.URI.create("/feature")).build();
    }

    @CheckedTemplate(basePath = "feature")
    public static class Templates {
        public static native TemplateInstance page(String title, String description);
    }

    @GET
    @Path("/feature")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance feature() {
        return Templates.page("Nested Layout Bug Reproduction", "This is a long description that should be truncated");
    }
}
