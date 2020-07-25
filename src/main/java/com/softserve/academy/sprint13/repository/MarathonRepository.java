package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Marathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {

    List<Marathon> getAll();
    Marathon getMarathonById  (Long id);
    Marathon createOrUpdate (Marathon marathon);
    void deleteMarathonById (Long id);

}
