package com.softserve.academy.sprint13;

import java.util.Properties;

import javax.sql.DataSource;


import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import com.softserve.academy.sprint13.repository.SprintRepository;
import com.softserve.academy.sprint13.repository.TaskRepository;
import com.softserve.academy.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Sprint13Application implements CommandLineRunner {

    @Autowired
    private MarathonRepository marathonRepository;
    @Autowired
    private SprintRepository sprintRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {

        SpringApplication.run(Sprint13Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        User user = new User();
        user.setRole("Trainee");
        user.setFirstName("Nick");
        user.setLastName("Doe");
        user.setPassword("12345");
        userRepository.save(user);

        System.out.println("-------------------------------------");
    }
}
