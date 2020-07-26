package com.softserve.academy.sprint13.repository;

import com.softserve.academy.sprint13.model.Marathon;
import com.softserve.academy.sprint13.model.Sprint;
import com.softserve.academy.sprint13.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

   @Query(value = "select * from user u where s.role=:role", nativeQuery = true)
   List<User> getAllByRole(@Param("role") String role);

}
