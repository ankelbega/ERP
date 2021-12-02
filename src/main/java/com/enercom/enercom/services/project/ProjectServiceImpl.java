package com.enercom.enercom.services.project;

import com.enercom.enercom.domain.Project;
import com.enercom.enercom.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = projectRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        projectRepository.delete(item);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public int save(SaveProjectRequest request) {
        var dbItem = projectRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setProjectHandled(request.getProjectHandled());
            dbItem.get().setDateStarted(request.getDateStarted());
            dbItem.get().setDateEnded(request.getDateEnded());
            dbItem.get().setStatus(request.getStatus());
            projectRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Project.builder()
                .projectHandled(request.getProjectHandled())
                .dateStarted(request.getDateStarted())
                .dateEnded(request.getDateEnded())
                .status(request.getStatus())
                .build();
        projectRepository.save(newItem);
        return newItem.getId();
    }
}
