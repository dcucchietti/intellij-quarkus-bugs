package com.example.extension;

import com.example.model.RoleType;
import io.quarkus.qute.TemplateExtension;

import java.util.Set;
import java.util.stream.Collectors;

@TemplateExtension(namespace = "role")
public class RoleExtension {

    public static String text(Set<RoleType> roles) {
        return roles.stream()
            .map(RoleType::name)
            .sorted()
            .collect(Collectors.joining(", "));
    }
}