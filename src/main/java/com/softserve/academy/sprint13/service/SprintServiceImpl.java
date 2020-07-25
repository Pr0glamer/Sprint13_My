package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public boolean updateSprint(Sprint sprint) {

        if(sprint!=null) {

        }

        return false;
    }

    @Override
    public Sprint getSprintById(Long id) {
        return null;
    }
}
