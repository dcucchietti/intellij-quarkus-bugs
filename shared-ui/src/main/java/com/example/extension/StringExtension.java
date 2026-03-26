package com.example.extension;

import io.quarkus.qute.TemplateExtension;

@TemplateExtension(namespace = "str")
public class StringExtension {

    public static String concat(String a, String b) {
        return a + b;
    }
}
