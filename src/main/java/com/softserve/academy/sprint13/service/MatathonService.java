package com.softserve.academy.sprint13.service;

import com.softserve.academy.sprint13.exception.EntityNotFoundException;
import com.softserve.academy.sprint13.model.Marathon;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MatathonService {
    public List<Marathon> getAll();
    public Marathon getMarathonById(Long id) throws EntityNotFoundException;
    public Marathon createOrUpdate(Marathon marathon);
    public void deleteMarathonById(Long id);


}
