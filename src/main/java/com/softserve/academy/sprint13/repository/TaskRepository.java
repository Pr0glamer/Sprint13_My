package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {


}
