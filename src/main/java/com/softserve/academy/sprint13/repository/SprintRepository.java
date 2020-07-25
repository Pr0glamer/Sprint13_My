package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    List<Sprint> getSprintsByMarathonId (Long id);
    boolean updateSprint (Sprint sprint);
    Sprint getSprintById (Long id);
}
