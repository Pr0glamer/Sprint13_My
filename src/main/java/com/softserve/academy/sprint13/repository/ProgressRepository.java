package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Progress getProgressById (Long id);
    Progress addOrUpdateProgress (Progress progress);
}
