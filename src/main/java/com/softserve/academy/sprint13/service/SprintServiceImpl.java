package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.repository.MarathonRepository;
import com.softserve.academy.sprint13.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {

        final private SprintRepository sprintRepository;
        final private MarathonRepository marathonRepository;

        public SprintServiceImpl(SprintRepository sprintRepository,
                                 MarathonRepository marathonRepository) {
            this.sprintRepository = sprintRepository;
            this.marathonRepository = marathonRepository;
        }

        @Override
        public Sprint create(Sprint sprint) {
            Sprint newSprint = sprintRepository.save(sprint);
            return newSprint;
        }

        @Override
        public boolean update(Sprint sprint) {
            Optional<Sprint> sprintFromBd = sprintRepository.findById(sprint.getId());
            if (sprintFromBd.isPresent()) {
                Sprint updatedSprint = sprintFromBd.get();
                updatedSprint.setFinish(sprint.getFinish());
                updatedSprint.setStartDate(sprint.getStartDate());
                updatedSprint.setTitle(sprint.getTitle());
                updatedSprint.setMarathon(sprint.getMarathon());
                sprintRepository.save(updatedSprint);
                return true;
            }
            return false;
        }

        @Override
        public void deleteSprint(Sprint sprint) {
            sprintRepository.delete(sprint);
        }

        @Override
        public Sprint getSprintById(Long id) throws EntityNotFoundException {
            Optional<Sprint> sprint = sprintRepository.findById(id);
            if (sprint.isPresent()) {
                return sprint.get();
            } else {
                throw new EntityNotFoundException("Task with id "+id+" was not found");
            }
        }

        @Override
        public List<Sprint> getAll() {
            List<Sprint> sprints = sprintRepository.findAll();
            if (!sprints.isEmpty()) {
                return sprints;
            }
            return new ArrayList<>();
        }

        @Override
        public List<Sprint> getSprintsByMarathonId(Long id) {
            List<Sprint> sprints = sprintRepository.getSprintsByMarathonId(id);
            if (!sprints.isEmpty()) {
                return sprints;
            }
            return new ArrayList<>();
        }

        @Override
        public boolean addSprintToMarathon(Sprint sprint, Marathon marathon) {
            Optional<Marathon> marathonFromId = marathonRepository.findById(marathon.getId());
            if (marathonFromId.isPresent()) {
                sprint.setMarathon(marathonFromId.get());
                sprintRepository.save(sprint);
                return true;
            }
            return false;
        }
}