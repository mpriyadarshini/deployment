package com.application.deployment.dto;//which ia a dto

public class CreateOrUpdateAppRequest {
    private final String name;
    private final String description;
    private final String url;

    public CreateOrUpdateAppRequest(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
