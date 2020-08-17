package com.application.deployment.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String url;
    private final Timestamp createdAt;

    @OneToMany(mappedBy = "app")
    private final List<Deployment> deployments;

    protected App() {
        this.createdAt = null;
        this.deployments = List.of();
    }

    public App(String name, String description, String url, Timestamp createdAt) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
        this.deployments = List.of();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public List<Deployment> getDeployments() {
        return deployments;
    }
}
