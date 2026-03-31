package com.example.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Controller demonstrating the false positive when using flag:enabled()
 * with a @TemplateEnum argument in Qute templates.
 *
 * The Qute language server reports:
 * "The method enabled(String) in the type null is not applicable
 *  for the arguments (FeatureFlag). qute (InvalidMethodParameter)"
 *
 * At runtime, FeatureFlag.toString() returns the key string, so
 * flag:enabled(FeatureFlag:ALPHA) works correctly — this is a
 * false positive in the IntelliJ Qute plugin validation.
 */
@Path("/feature-flag")
public class FeatureFlagController {

    @CheckedTemplate(basePath = "feature-flag")
    public static class Templates {
        public static native TemplateInstance page();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        return Templates.page();
    }
}
