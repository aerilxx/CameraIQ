package com.example.CameraIQInterview.Organization;

import com.example.CameraIQInterview.User.User;
import com.example.CameraIQInterview.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(OrganizationController.BASE_URL)
public class OrganizationController {

    public static final String BASE_URL = "/api/organization";

    @Autowired
    private OrganizationRepository orgRepo;
    @Autowired
    private  UserRepository userRepo;

    // method to display all organizations
    @GetMapping
    public ResponseEntity<Collection<Organization>> getUser() {
        return new ResponseEntity<>(orgRepo.findAll(), HttpStatus.OK);
    }

    // method to get single organization by id
    @GetMapping("/{orgId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable  Long orgId){
        Optional<Organization> org = orgRepo.findById(orgId);
        if (org.isPresent()) {
            return new ResponseEntity<Organization>(org.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // method to create single organization
    @PostMapping
    public ResponseEntity<?> saveOrg(@RequestBody Organization organization){
        return new ResponseEntity<>(orgRepo.save(organization), HttpStatus.CREATED);
    }

    // method to add user to organization
    @PostMapping("/{orgId}/add/{userId}")
    public ResponseEntity<?> addUserToOrg(@PathVariable Long orgId, @PathVariable Long userId){
        Optional<User> user = userRepo.findById(userId);
        Optional<Organization> org = orgRepo.findById(orgId);
        if (!user.isPresent() || !org.isPresent()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else{
            org.get().getUser().add(user.get());
            return new ResponseEntity<>(orgRepo.save(org.get()), HttpStatus.CREATED);
        }
    }

    // method to delete user from organization
    @DeleteMapping("/{orgId}/delete/{userId}")
    public ResponseEntity<Void> deleteUserFromOrg(@PathVariable Long orgId, @PathVariable Long userId){
        Optional<User> user = userRepo.findById(userId);
        Optional<Organization> org = orgRepo.findById(orgId);
        if (!user.isPresent() || !org.isPresent()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else{
            org.get().getUser().remove(user.get());
            orgRepo.save(org.get());
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
}
