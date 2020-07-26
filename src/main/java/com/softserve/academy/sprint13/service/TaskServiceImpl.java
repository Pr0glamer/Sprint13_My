package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.repository.SprintRepository;
import com.softserve.academy.sprint13.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;
    final private SprintRepository sprintRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.sprintRepository = sprintRepository;
    }



    public Task createTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask;
    }


    public Task update(Task task) throws EntityNotFoundException {
        Optional<Task> taskFromDb = taskRepository.findById(task.getId());
        if (taskFromDb.isPresent()) {
            Task newTask = taskFromDb.get();
            newTask.setTitle(task.getTitle());
            newTask.setCreated(task.getCreated());
            newTask.setProgresses(task.getProgresses());
            newTask.setSprint(task.getSprint());
            newTask.setUpdated(task.getUpdated());
            newTask = taskRepository.save(newTask);
            return newTask;
        } else {
            throw new EntityNotFoundException("Task doesn't exist");
        }
    }


    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) throws EntityNotFoundException {
        Optional<Sprint> sprintFromBd = sprintRepository.findById(sprint.getId());
        if (sprintFromBd.isPresent()) {
            task.setSprint(sprintFromBd.get());
            Task newTask = taskRepository.save(task);
            return newTask;
        } else {
            throw new EntityNotFoundException("No sprint with id " + sprint.getId());
        }
    }



    public Task getTaskById(Long id) throws EntityNotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new EntityNotFoundException("No task with id " + id);
        }
    }


    public List<Task> getAll() {
        List<Task> tasks = taskRepository.findAll();
        if (!tasks.isEmpty()) {
            return tasks;
        }
        return new ArrayList<>();
    }
}