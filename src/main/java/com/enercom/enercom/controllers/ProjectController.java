package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Project;
import com.enercom.enercom.services.project.ProjectService;
import com.enercom.enercom.services.project.SaveProjectRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable int id) {
        var item = this.projectService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Project> getAll() {
        return projectService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveProjectRequest request) {
        return projectService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        projectService.delete(id);
    }
}
