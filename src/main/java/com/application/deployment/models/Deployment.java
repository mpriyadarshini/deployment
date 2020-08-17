package com.application.deployment.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Deployment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private final App app;
    private final String revision;
    private final String changelog;
    private final String description;
    private final String user;
    private final Date createdAt;

    public Deployment(App app, String revision, String changelog, String description, String user, Date createdAt) {
        this.app = app;
        this.revision = revision;
        this.changelog = changelog;
        this.description = description;
        this.user = user;
        this.createdAt = createdAt;
    }

    public String getRevision() {
        return revision;
    }

    public String getChangelog() {
        return changelog;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public App getApp() {
        return app;
    }
}
