package com.softserve.academy.sprint13.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

        @ManyToMany
    @JoinTable(
            name = "maraphon_user",
            joinColumns = @JoinColumn(name = "marathon_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany(mappedBy = "marathon")
    private List<Sprint> sprints;


}
