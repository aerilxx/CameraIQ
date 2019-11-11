package com.example.CameraIQInterview.Organization;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;

}
