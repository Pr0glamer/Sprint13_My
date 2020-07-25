package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;

import java.util.List;

public interface TaskService {

    public Task addTaskToSprint(Task task, Sprint sprint);
    public Task getTaskById(Long id);

}
