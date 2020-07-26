package com.softserve.academy.sprint13.service;


import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;


public interface TaskService {

    public Task addTaskToSprint(Task task, Sprint sprint) throws EntityNotFoundException;
    public Task getTaskById(Long id) throws EntityNotFoundException;
    Task createTask(Task task);
}
