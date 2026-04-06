package com.example.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Controller demonstrating the false MissingRequiredParameter warning
 * when a user tag uses a @TemplateGlobal variable that is not passed
 * explicitly by the caller.
 */
@Path("/template-global-tag")
public class TemplateGlobalTagController {

    @CheckedTemplate(basePath = "template-global-tag")
    public static class Templates {
        public static native TemplateInstance page();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page();
    }
}
