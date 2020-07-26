package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Progress;
import com.softserve.academy.sprint13.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    @Query("select p from progress p" +
            "inner join marathon_user mu " +
            "on mu.user_id = p.trainee_id " +
            "where mu.marathon_id = :marathonId and mu.user_id=:user_id")
    List<Progress> allProgressByUserIdAndMarathonId(@Param("user_id")Long userId, @Param("marathonId")Long marathonId);

    @Query("select p from progress p" +
            "inner join task t " +
            "on t.id = p.task_id " +
            "where t.sprint_id = :sprint_id and p.trainee_id=:user_id")

    List<Progress> allProgressByUserIdAndSprintId(@Param("user_id")Long userId, @Param("sprintId")Long sprintId);

}
