package com.example.controller;

import com.example.model.RoleType;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Set;

@Path("/namespace-extension")
public class NamespaceExtensionController {

    public record UserRow(String name, Set<RoleType> roles) {
    }

    @CheckedTemplate(basePath = "namespace-extension")
    public static class Templates {
        public static native TemplateInstance page(List<UserRow> users);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        var users = List.of(
            new UserRow("Alice", Set.of(RoleType.ADMINISTRATOR, RoleType.BUYER)),
            new UserRow("Bob", Set.of(RoleType.VIEWER))
        );
        return Templates.page(users);
    }
}