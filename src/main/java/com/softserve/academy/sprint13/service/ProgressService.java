package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.model.Progress;
import com.softserve.academy.sprint13.model.Task;
import com.softserve.academy.sprint13.model.TaskStatus;
import com.softserve.academy.sprint13.model.User;

import java.util.List;

public interface ProgressService {

    public Progress getProcessById(Long id);
    public Progress addTaskForStudent(Task task, User user);
    public Progress addOrUpdateProgress(Progress progress);
    public boolean setStatus(TaskStatus status, Progress progress);
    public List<Progress> allProgressByUserIdAndMarathonId(Long userid, Long marathonid);
    public List<Progress> allProgressByUserIdAndSprintId(Long userid, Long sprintid);



}
