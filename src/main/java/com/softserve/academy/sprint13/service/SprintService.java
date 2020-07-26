package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.*;

import java.util.List;

public interface SprintService {

    Sprint create(Sprint sprint);

    boolean update(Sprint sprint);

    void deleteSprint(Sprint sprint);

    Sprint getSprintById(Long id) throws EntityNotFoundException;

    List<Sprint> getAll();

    List<Sprint> getSprintsByMarathonId(Long id);

    boolean addSprintToMarathon(Sprint sprint, Marathon marathon);



}
