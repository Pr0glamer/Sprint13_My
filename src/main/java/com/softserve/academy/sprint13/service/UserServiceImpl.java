package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import com.softserve.academy.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    final private MarathonRepository marathonRepository;

    public UserServiceImpl(UserRepository userRepository, MarathonRepository marathonRepository) {
        this.userRepository = userRepository;
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return new ArrayList<>();
        }
        return users;
    }

    @Override
    public User getUserById(Long id) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new EntityNotFoundException("There isn't user with id = " + id);
        }
    }

    @Override
    public User createOrUpdateUser(User entity) {
        if (entity.getId() != null) {
            Optional<User> user = userRepository.findById(entity.getId());
            User newUser = user.get();
            newUser.setEmail(entity.getEmail());
            newUser.setFirstName(entity.getFirstName());
            newUser.setLastName(entity.getLastName());
            newUser.setPassword(entity.getPassword());
            newUser = userRepository.save(newUser);
            return newUser;
        }
        entity = userRepository.save(entity);
        return entity;
    }

    @Override
    public List<User> getAllByRole(String role) {
        return userRepository.getAllByRole(role);
    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) throws EntityNotFoundException {
        Optional<Marathon> marathonFromBd = marathonRepository.findById(marathon.getId());
        if (marathonFromBd.isPresent()) {
            List<User> users = marathonFromBd.get().getUsers();
            if(users == null) {
                users = new ArrayList<>();
            }

            if (!users.contains(user)) {
                users.add(user);
                marathonFromBd.get().setUsers(users);
                marathonRepository.save(marathonFromBd.get());
                return true;
            }
        } else {
            throw new EntityNotFoundException("There isn't marathon " + marathon.getTitle());
        }
        return false;
    }


    public boolean addUserToTask(User user, Task task) {
        return false;
    }


    public boolean delete(User user) {
        Optional<User> deleted = userRepository.findById(user.getId());
        if (deleted.isPresent()) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }


}
