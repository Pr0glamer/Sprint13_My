package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> getAllByRole(String role);
    List<User> getAll();
    User getUserById(Integer id);
    User createOrUpdateUser(User user);

    //TO DELETE Should be in Sevice module
    //boolean addUserToMarathon(User user, Marathon marathon);



}
