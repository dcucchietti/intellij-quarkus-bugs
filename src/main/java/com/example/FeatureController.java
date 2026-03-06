package com.example;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Controller demonstrating the nested layout pattern that triggers
 * a false positive in the Qute language server.
 *
 * @see <a href="https://github.com/redhat-developer/intellij-quarkus/issues/1557">Issue #1557</a>
 */
@Path("/feature")
public class FeatureController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance page(String title);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page("Nested Layout Bug Reproduction");
    }
}
