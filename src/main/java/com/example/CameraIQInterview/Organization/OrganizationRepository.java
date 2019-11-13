package com.example.CameraIQInterview.Organization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    Collection<Organization> findAll();
}
