package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MarathonServiceImpl implements MatathonService {

    final private MarathonRepository marathonRepository;

    public MarathonServiceImpl(MarathonRepository marathonRepository) {
        this.marathonRepository = marathonRepository;
    }

    @Override
    public List<Marathon> getAll() {
        List<Marathon> marathons = marathonRepository.findAll();
        if (marathons.isEmpty()) {

            return new ArrayList<>();
        }
        return marathons;
    }

    @Override
    public Marathon getMarathonById(Long id) throws EntityNotFoundException {
        Optional<Marathon> marathon = marathonRepository.findById(id);
        if (marathon.isPresent()) {
            return marathon.get();
        } else {
            throw new EntityNotFoundException("There isn't marathon with id " + id);

        }
    }

    @Override
    public Marathon createOrUpdate(Marathon entity) {
        if (entity.getId() != null) {
            Optional<Marathon> marathon = marathonRepository.findById(entity.getId());
            Marathon newMarathon = marathon.get();
            newMarathon.setTitle(entity.getTitle());
            return newMarathon;
        }
        entity = marathonRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteMarathonById(Long id) {
        Optional<Marathon> marathon = marathonRepository.findById(id);
        if (marathon.isPresent()) {
            marathonRepository.delete(marathon.get());
        }
    }
}
