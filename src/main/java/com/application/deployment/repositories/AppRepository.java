package com.application.deployment.repositories;

import com.application.deployment.models.App;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppRepository extends CrudRepository<App, Long> {
    List<App> findAll();
}
