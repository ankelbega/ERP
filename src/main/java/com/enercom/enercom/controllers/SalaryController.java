package com.enercom.enercom.controllers;


import com.enercom.enercom.domain.Salary;
import com.enercom.enercom.services.salary.SalaryService;
import com.enercom.enercom.services.salary.SaveSalaryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
    private SalaryService salaryService;

    public SalaryController(final SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> get(@PathVariable int id) {
        var item = this.salaryService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Salary> getAll() {
        return salaryService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveSalaryRequest request) {
        return salaryService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        salaryService.delete(id);
    }
}
