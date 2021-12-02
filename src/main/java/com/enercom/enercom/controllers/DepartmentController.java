package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Department;
import com.enercom.enercom.services.department.DepartmentService;
import com.enercom.enercom.services.department.SaveDepartmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(final DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable int id) {
        var item = this.departmentService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveDepartmentRequest request) {
        return departmentService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        departmentService.delete(id);
    }
}
