package com.application.deployment.repositories;

import com.application.deployment.models.App;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<App,Long> {
}
