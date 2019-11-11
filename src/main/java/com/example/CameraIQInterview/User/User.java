package com.example.CameraIQInterview.User;

import com.example.CameraIQInterview.Organization.Organization;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    @ManyToOne
    private Organization organization;

}
