package com.example.CameraIQInterview.Organization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class loadOrgData implements CommandLineRunner {

    private final OrganizationRepository organizationRepository;

    public loadOrgData(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    public void run(String... args) throws Exception{
/*
        User o1 = new User();
        o1.setName("Doglover");
        o1.setAddress("123 santa monica ave");
        o1.setPhone("123-123-1234");
        organizationRepository.save(o1);

        User o2 = new User();
        o2.setName("Catlover");
        o2.setAddress("123 admiralty ave");
        o2.setPhone("321-123-1234");
        organizationRepository.save(o2);

        User o3 = new User();
        o3.setName("Birdlover");
        o3.setAddress("123 keyston st");
        o3.setPhone("123-223-1234");
        organizationRepository.save(o3);

        System.out.println("save some organization to db!");
*/
    }


}
