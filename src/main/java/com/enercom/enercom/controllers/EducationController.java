package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Education;
import com.enercom.enercom.services.education.EducationService;
import com.enercom.enercom.services.education.SaveEducationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private EducationService educationService;

    public EducationController(final EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> get(@PathVariable int id) {
        var item = this.educationService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Education> getAll() {
        return educationService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveEducationRequest request) {
        return educationService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        educationService.delete(id);
    }
}
