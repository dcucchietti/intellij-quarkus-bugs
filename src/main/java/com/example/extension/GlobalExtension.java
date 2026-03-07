package com.example.extension;

import io.quarkus.qute.TemplateExtension;

/**
 * Qute template extension demonstrating the false "unused" warning
 * on methods referenced only from Qute templates.
 */
@TemplateExtension
public class GlobalExtension {

    /**
     * Extension method callable on any String in templates.
     * Usage: {someString.ellipsis(20)}
     */
    public static String ellipsis(String value, int maxLength) {
        if (value == null || value.length() <= maxLength) {
            return value;
        }
        return value.substring(0, maxLength) + "…";
    }
}
