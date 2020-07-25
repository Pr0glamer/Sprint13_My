package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class SprintServiceImpl implements SprintService {
    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public List<Sprint> getSprintsByMarathonId(Long id) {
        return sprintRepository.getSprintsByMarathonId(id);
    }

    @Override
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
        if(marathon!=null  && sprint !=null) {
            marathon.getSprints().add(sprint);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateSprint(Sprint entity) {

        if(entity.getId()!=null) {
            Sprint newSprint = new Sprint();
            newSprint.setTitle(entity.getTitle());
            newSprint = sprintRepository.save(newSprint);
            return true;

        }

        return false;
    }

    @Override
    public Sprint getSprintById(Long id) {
        return sprintRepository.getSprintById(id);
    }
}
