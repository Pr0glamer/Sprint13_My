package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MatathonServiceImpl {

    @Autowired
    private MarathonRepository marathonRepository;

    public List<Marathon> getAll() {

        return marathonRepository.getAll();
    }
    public Marathon getMarathonById(Long id) {

        return marathonRepository.getMarathonById(id);
    }
    public Marathon createOrUpdate(Marathon entity) {
        if(entity.getId() != null) {
            Marathon marathon = marathonRepository.getMarathonById(entity.getId());

            if(marathon != null) {

                Marathon newMar = new Marathon();
                newMar.setTitle(entity.getTitle());
                newMar = marathonRepository.save(newMar);
                return newMar;

            }

        }
        entity = marathonRepository.save(entity);
        return entity;
    }
    public void deleteMarathonById(Long id) {
        Marathon entity = marathonRepository.getMarathonById(id);
        marathonRepository.deleteMarathonById(id);

    }




}
