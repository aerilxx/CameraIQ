package com.example.CameraIQInterview.Organization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrganizationController.BASE_URL)
public class OrganizationController {

    public static final String BASE_URL = "/api/organization";

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @GetMapping
    List<Organization> getAllOrganization(){
        return organizationService.findAllOrganization();
    }

    @GetMapping("/{name}")
    public Organization getOrganizationByName(@PathVariable  String name){
        return organizationService.findOrganizationByName(name);
    }

    // method to create single organization
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization saveOrg(@RequestBody Organization organization){
        return organizationService.saveOrganization(organization);
    }

}
