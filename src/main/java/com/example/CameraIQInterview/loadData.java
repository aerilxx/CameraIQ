package com.example.CameraIQInterview;

import com.example.CameraIQInterview.Organization.Organization;
import com.example.CameraIQInterview.Organization.OrganizationRepository;
import com.example.CameraIQInterview.User.User;
import com.example.CameraIQInterview.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class loadData implements CommandLineRunner {

    private OrganizationRepository organizationRepository;
    private  UserRepository userRepository;

    public loadData(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    public void run(String... args) throws Exception{

        Organization o1 = new Organization();
        o1.setName("Doglover");
        o1.setAddress("123 santa monica ave");
        o1.setPhone("123-123-1234");

        System.out.println("save some organization to db!");

        User u1 = new User();
        u1.setFirstName("Alice");
        u1.setLastName("Shao");
        u1.setEmail("alice@gmail.com");
        u1.setAddress("123 monica ave");
        u1.setPhone("123-123-1234");


        Set<User> user = new HashSet<>();
        Set<Organization> organization = new HashSet<>();
        u1.setOrganization(organization);
        o1.setUser(user);

        userRepository.save(u1);
        organizationRepository.save(o1);

        System.out.println("save some users to db!");

    }

}
