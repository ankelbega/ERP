package com.enercom.enercom.services.project;

import com.enercom.enercom.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();

    Optional<Project> findById(int id);

    int save(SaveProjectRequest request);

    void delete(int id);
}
