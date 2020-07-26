package com.softserve.academy.sprint13;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.sql.DataSource;
import javax.transaction.Transactional;


import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import com.softserve.academy.sprint13.repository.SprintRepository;
import com.softserve.academy.sprint13.repository.TaskRepository;
import com.softserve.academy.sprint13.repository.UserRepository;
import com.softserve.academy.sprint13.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Sprint13Application implements CommandLineRunner {

    private UserService userService;
    private MarathonService marathonService;
    private SprintService sprintService;
    private TaskService taskService;
    private ProgressService progressService;

    public Sprint13Application(UserService userService,
                       MarathonService marathonService, SprintService sprintService,
                       TaskService taskService, ProgressService progressService) {
        this.userService = userService;
        this.marathonService = marathonService;
        this.sprintService = sprintService;
        this.taskService = taskService;
        this.progressService = progressService;
    }


    public static void main(String[] args) {

        SpringApplication.run(Sprint13Application.class, args);


    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        Marathon marathon = null;
        for (int i = 1; i <= 5; i++) {
            try {
                marathon = new Marathon();
                marathon.setTitle("Maraphon " + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            marathonService.createOrUpdate(marathon);
        }


        User user = null;
        for (int i = 1; i <= 5; i++) {
            try {
                user = new User();
                user.setRole("Trainee " + i);
                user.setFirstName("Name " + i);
                user.setLastName("Last name " + i);
                if (i < 3) {
                    user.setRole("Student");
                } else {
                    user.setRole("Mentor");
                }
                user.setPassword(String.valueOf(i));
                user.setEmail(user.getLastName() + "@fmail.com");
                userService.createOrUpdateUser(user);
                User userFromDb = userService.createOrUpdateUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        User u = userService.getUserById(1L);
        Marathon m = marathonService.getMarathonById(2L);
        userService.addUserToMarathon(user, marathon);

        List<User> students = userService.getAllByRole("Student");
        students.forEach(System.out::println);


        marathonService.getAll().forEach(System.out::println);


    }
}
