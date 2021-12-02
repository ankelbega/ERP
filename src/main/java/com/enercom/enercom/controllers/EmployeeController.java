package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Employee;
import com.enercom.enercom.services.employee.EmployeeService;
import com.enercom.enercom.services.employee.SaveEmployeeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable int id) {
        var item = this.employeeService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveEmployeeRequest request) {
        return employeeService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
