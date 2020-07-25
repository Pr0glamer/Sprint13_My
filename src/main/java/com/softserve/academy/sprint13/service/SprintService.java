package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.*;

import java.util.List;

public interface SprintService {

    public List<Sprint> getSprintsByMarathonId(Long id);
    public boolean addSprintToMarathon(Sprint sprint, Marathon marathon);
    public boolean updateSprint(Sprint sprint);
    public Sprint getSprintById(Long id);



}
