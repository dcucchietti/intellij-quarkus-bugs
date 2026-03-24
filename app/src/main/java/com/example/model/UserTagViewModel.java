package com.example.model;

import java.util.List;
import java.util.Set;

/**
 * View model with a nested record, mimicking the real-world pattern.
 */
public record UserTagViewModel(List<PermissionRow> permissions) {

    public record PermissionRow(
        Long id,
        String code,
        String name,
        Set<RoleType> roles
    ) {
    }
}