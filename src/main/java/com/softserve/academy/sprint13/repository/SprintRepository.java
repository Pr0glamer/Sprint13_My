package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query(value = "select * from sprint s where s.marathon_id = :id", nativeQuery = true)
    List<Sprint> getSprintsByMarathonId (@Param("id")Long id);

}
