package com.softserve.academy.sprint13.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String email;
    @NotBlank
    private String first_name;
    @NotBlank
    private String last_name;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

    @ManyToMany(mappedBy = "users")
    private List<Marathon> marathons;

    @OneToMany(mappedBy = "user")
    private List<Progress> progresses;





}
