package com.softserve.academy.sprint13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarathonRepository extends JpaRepository<Marathon, Long> {
}
