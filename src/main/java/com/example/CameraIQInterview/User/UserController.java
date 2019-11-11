package com.example.CameraIQInterview.User;

import com.example.CameraIQInterview.Organization.Organization;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/user";

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // read all users who belong to a specific organization
    @GetMapping("/{organization}")
    public List<User> getAllUsersByOrganization(@PathVariable String organization){
        return userService.findUserByOrg(organization);
    }

    // method to create single user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveOrg(@RequestBody User user){
        return userService.saveUser(user);
    }

}
