package com.example.CameraIQInterview.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //List<User> findAllUser(){ return userRepository.findAll(); }

    public List<User> findUserByOrg(String org){
        return userRepository.findByOrganizationName(org);
    }

    public User saveUser(User user) {
        return  userRepository.save(user);
    }
}
