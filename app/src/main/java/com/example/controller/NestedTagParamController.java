package com.example.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Controller demonstrating the false UndefinedSectionTag warning when a caller
 * fills a named {#insert} slot defined inside a user tag.
 */
@Path("/nested-tag-param")
public class NestedTagParamController {

    @CheckedTemplate(basePath = "nested-tag-param")
    public static class Templates {
        public static native TemplateInstance page();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page();
    }
}