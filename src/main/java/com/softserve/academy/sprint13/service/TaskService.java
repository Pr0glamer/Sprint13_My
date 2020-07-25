package com.softserve.academy.sprint13.service;


import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.Task;


public interface TaskService {

    public Task addTaskToSprint(Task task, Sprint sprint);

}
