package com.softserve.academy.sprint13.service;


import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Progress;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.model.User;
import com.softserve.academy.sprint13.repository.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
 public class ProgressServiceImpl implements ProgressService {

     final private ProgressRepository progressRepository;
     final private MarathonRepository marathonRepository;
     final private UserRepository userRepository;
     final private SprintRepository sprintRepository;
     final private TaskRepository taskRepository;


     public ProgressServiceImpl(ProgressRepository progressRepository,
                                MarathonRepository marathonRepository,
                                UserRepository userRepository, SprintRepository sprintRepository,
                                TaskRepository taskRepository) {
         this.progressRepository = progressRepository;
         this.marathonRepository = marathonRepository;
         this.userRepository = userRepository;
         this.sprintRepository = sprintRepository;
         this.taskRepository = taskRepository;
     }


     public Progress create(Progress progress) {
         Progress newProgress = progressRepository.save(progress);
         return newProgress;

     }


     public void delete(Progress progress) {

         progressRepository.delete(progress);
     }


     public Progress getProgressById(Long id) throws EntityNotFoundException {
         Optional<Progress> progress = progressRepository.findById(id);
         if (progress.isPresent()) {
             return progress.get();
         } else {
             throw new EntityNotFoundException("No progress with id "+id);
         }
     }


     public List<Progress> getAll() {
         List<Progress> progresses = progressRepository.findAll();
         if (!progresses.isEmpty()) {
             return progresses;
         }
         return new ArrayList<>();
     }

     @Override
     public Progress addTaskForStudent(Task task, User user) throws EntityNotFoundException {
         Progress progress = new Progress();
         Optional<Task> taskFromBd = taskRepository.findById(task.getId());
         Optional<User> userFromBd = userRepository.findById(user.getId());
         if (userFromBd.isPresent() && taskFromBd.isPresent()) {
             Progress progressFromDb = progressRepository.save(progress);
             progressFromDb.setTask(taskFromBd.get());
             progressFromDb.setUser(userFromBd.get());
             return progressRepository.save(progress);
         } else {
             throw new EntityNotFoundException("No task or user");
         }
     }


     public Progress addOrUpdateProgress(Progress progress) {
         Optional<Progress> progressFromBd = progressRepository.findById(progress.getId());
         if (progressFromBd.isPresent()) {
             Progress p = new Progress();
             p.setUser(progress.getUser());
             p.setStarted(progress.getStarted());
             p.setStatus(progress.getStatus());
             p.setTask(p.getTask());
             p.setUpdated(LocalDate.now());
             p = progressRepository.save(p);
             return p;

         }
         progress = progressRepository.save(progress);
         return progress;



     }


     public boolean setStatus(String status, Progress progress) {
         Optional<Progress> progressFromBd = progressRepository.findById(progress.getId());
         if (progressFromBd.isPresent()) {
             Progress newProgress = progressFromBd.get();
             newProgress.setStatus(status.toString());
             progressRepository.save(newProgress);
             return true;
         } else {
             return false;
         }
     }


     public List<Progress> allProgressByUserIdAndMarathonId(Long userId, Long marathonId) {
         return progressRepository.allProgressByUserIdAndMarathonId(userId, marathonId);
     }


     public List<Progress> allProgressByUserIdAndSprintId(Long userId, Long sprintId) {

         return progressRepository.allProgressByUserIdAndSprintId(userId, sprintId);

     }

}
