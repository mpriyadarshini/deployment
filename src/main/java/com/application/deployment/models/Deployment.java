package com.application.deployment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Deployment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private final String revision;
    private final String changelog;
    private final String description;
    private final String user;
    private final Date createdAt;

    public Deployment(String revision, String changelog, String description, String user, Date createdAt) {
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
}
