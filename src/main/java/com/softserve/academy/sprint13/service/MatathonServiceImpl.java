package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatathonServiceImpl implements MatathonService{

    @Autowired
    private MarathonRepository marathonRepository;

    @Override
    public List<Marathon> getAll() {

        return marathonRepository.getAll();
    }
    @Override
    public Marathon getMarathonById(Long id) {

        return marathonRepository.getMarathonById(id);
    }
    @Override
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
    @Override
    public void deleteMarathonById(Long id) {
        Marathon entity = marathonRepository.getMarathonById(id);
        marathonRepository.deleteMarathonById(id);

    }




}
