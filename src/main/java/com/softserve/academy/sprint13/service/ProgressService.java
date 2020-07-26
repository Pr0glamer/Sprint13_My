package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Progress;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.model.User;

import java.util.List;

public interface ProgressService {

    public Progress getProgressById(Long id) throws EntityNotFoundException;
    public Progress addTaskForStudent(Task task, User user) throws EntityNotFoundException;
    public Progress addOrUpdateProgress(Progress progress);
    public boolean setStatus(String status, Progress progress);
    public List<Progress> allProgressByUserIdAndMarathonId(Long userid, Long marathonid);
    public List<Progress> allProgressByUserIdAndSprintId(Long userid, Long sprintid);



}
