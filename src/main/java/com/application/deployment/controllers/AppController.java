package com.application.deployment.controllers;

import com.application.deployment.dto.CreateOrUpdateAppRequest;
import com.application.deployment.models.App;
import com.application.deployment.models.Deployment;
import com.application.deployment.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {

    private final AppRepository appRepository;

    public AppController(@Autowired AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @GetMapping
    public List<App> listAll() {
        return appRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<App> getById(@PathVariable("id") long id) {
        return ResponseEntity.of(appRepository.findById(id));
    }

    @PostMapping
    public App create(@RequestBody CreateOrUpdateAppRequest request) {
        Timestamp createdAt = Timestamp.from(Instant.now());
        App newApp = new App(request.getName(),request.getDescription(),request.getUrl(), createdAt);
        appRepository.save(newApp);
        return newApp;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<App> update(@PathVariable("id") long id, @RequestBody CreateOrUpdateAppRequest request) {
        return ResponseEntity.of(appRepository.findById(id).map(app -> {
            app.setName(request.getName());
            app.setDescription(request.getDescription());
            app.setUrl(request.getUrl());

            appRepository.save(app);

            return app;
        }));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        return appRepository.findById(id)
                .map(app -> {
                    appRepository.delete(app);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
