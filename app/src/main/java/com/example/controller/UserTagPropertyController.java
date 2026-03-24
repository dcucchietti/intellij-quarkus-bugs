package com.example.controller;

import com.example.model.RoleType;
import com.example.model.UserTagViewModel;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Set;

/**
 * Controller demonstrating the false UnknownProperty warning when passing
 * a record field directly as a user tag parameter.
 */
@Path("/user-tag-property")
public class UserTagPropertyController {

    @CheckedTemplate(basePath = "user-tag-property")
    public static class Templates {
        public static native TemplateInstance page(UserTagViewModel model);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance page() {
        var permissions = List.of(
            new UserTagViewModel.PermissionRow(1L, "FR", "France", Set.of(RoleType.ADMINISTRATOR, RoleType.BUYER)),
            new UserTagViewModel.PermissionRow(2L, "DE", "Germany", Set.of(RoleType.VIEWER))
        );
        return Templates.page(new UserTagViewModel(permissions));
    }
}