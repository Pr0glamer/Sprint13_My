package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.repository.SprintRepository;
import com.softserve.academy.sprint13.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    final private TaskRepository taskRepository;
    final private SprintRepository sprintRepository;

    public TaskServiceImpl(TaskRepository taskRepository, SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Task addTaskToSprint(Task task, Sprint sprint) {
        if (task != null & sprint != null) {
            sprint.getTasks().add(task);
            return task;
        }
        return null;
    }
}
