package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllByRole(String role);
    List<User> getAll();
    User getUserById(Long id) throws EntityNotFoundException;
    User createOrUpdateUser(User user);
    boolean addUserToMarathon(User user, Marathon mrp) throws EntityNotFoundException;

}
