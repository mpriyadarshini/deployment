package com.application.deployment.repositories;

import com.application.deployment.models.Deployment;
import org.springframework.data.repository.CrudRepository;

public interface DeploymentRepository extends CrudRepository<Deployment,Long> {

    
}
