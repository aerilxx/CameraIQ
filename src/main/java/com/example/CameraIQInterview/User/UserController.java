package com.example.CameraIQInterview.User;

import com.example.CameraIQInterview.Organization.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/user";

    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public ResponseEntity<Collection<User>> getUser() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    // method to create single user
    @PostMapping
    public ResponseEntity<?> addAllUsers(@RequestBody User user){
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    // method to get single user by id
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable  Long userId){
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userRepo.deleteById(userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // read all users who belong to a specific organization
    @GetMapping("/{userId}/organization")
    public ResponseEntity<Collection<Organization>> getUserByOrg(@PathVariable long userId) {
        Optional<User> user = userRepo.findById(userId);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get().getOrganization(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
