package com.example.CameraIQInterview.User;

import com.example.CameraIQInterview.Organization.Organization;
import com.example.CameraIQInterview.Organization.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class loadUserData implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrganizationRepository organizationRepository;

    public loadUserData(UserRepository userRepository, OrganizationRepository organizationRepository){
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    public void run(String... args) throws Exception{

        // Clean up database tables
        organizationRepository.deleteAllInBatch();
        userRepository.deleteAll();

        // Create a Org instance
        Organization o1 = new Organization();
        o1.setName("Doglover");
        o1.setAddress("123 santa monica ave");
        o1.setPhone("123-123-1234");
        organizationRepository.save(o1);

        User u1 = new User();
        u1.setFirstName("Alice");
        u1.setLastName("Shao");
        u1.setEmail("alice@gmail.com");
        u1.setAddress("123 monica ave");
        u1.setPhone("123-123-1234");
        u1.setOrganization(o1);
        userRepository.save(u1);

        User u2 = new User();
        u2.setFirstName("John");
        u2.setLastName("Doe");
        u2.setEmail("john@gmail.com");
        u2.setAddress("222 cameral ave");
        u2.setPhone("123-123-4321");
        u2.setOrganization(o1);
        userRepository.save(u2);

        User u3 = new User();
        u3.setFirstName("Kelly");
        u3.setLastName("Stwart");
        u3.setEmail("kelly@gmail.com");
        u3.setAddress("123 shelton st");
        u3.setPhone("111-123-1234");
        u3.setOrganization(o1);
        userRepository.save(u3);

        System.out.println("save some users to db!");

    }


}
