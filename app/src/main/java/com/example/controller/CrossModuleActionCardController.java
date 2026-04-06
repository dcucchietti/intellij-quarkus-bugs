package com.example.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Controller demonstrating the cross-module actionCard UndefinedSectionTag bug.
 * The {#actionCard} tag is defined in the shared-ui module but IntelliJ
 * cannot resolve it and reports UndefinedSectionTag.
 */
@Path("/cross-module-action-card")
public class CrossModuleActionCardController {

    @CheckedTemplate(basePath = "cross-module-action-card")
    public static class Templates {
        public static native TemplateInstance page();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page();
    }
}
