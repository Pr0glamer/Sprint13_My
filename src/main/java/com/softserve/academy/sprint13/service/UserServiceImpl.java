package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import com.softserve.academy.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    @Autowired
    private MarathonRepository marathonRepository;

    @Transactional
    public List<User> getAllByRole(String role){
        return repository.getAllByRole(role);
    }
    @Transactional
    public List<User> getAll() {
        return repository.getAll();
    }
    @Transactional
    public User getUserById(Integer id) {
        return repository.getUserById(id);
    }
    @Transactional
    public User createOrUpdateUser(User entity) {
        if(entity.getId() != null) {
            Optional<User> us = repository.findById(entity.getId().intValue());

            if(us.isPresent()) {
                User newUser = us.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirst_name(entity.getFirst_name());
                newUser.setLast_name(entity.getFirst_name());
                newUser.setPassword(entity.getPassword());
                newUser.setRole(entity.getRole());
                newUser = repository.save(newUser);
                return newUser;

            }

        }
        entity = repository.save(entity);
        return entity;

    }
    @Transactional
    public boolean addUserToMarathon(User user, Marathon mrp){
        if(user!=null && mrp!=null) {
            mrp.getUsers().add(user);
            marathonRepository.createOrUpdate(mrp);
        }
        return true;
    }

}
