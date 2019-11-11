package com.example.CameraIQInterview.Organization;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;


    OrganizationService(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }


    public Organization findOrganizationByName(String name){
        return organizationRepository.findByName(name);
    }

    List<Organization> findAllOrganization(){
        return organizationRepository.findAll();
    }

    public Organization saveOrganization(Organization organization) {
        return  organizationRepository.save(organization);
    }
}
