package com.example.model;

import io.quarkus.qute.TemplateEnum;

@TemplateEnum
public enum FeatureFlag {
    ALPHA("alpha"),
    BETA("beta");

    private final String key;

    FeatureFlag(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
