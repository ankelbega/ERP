package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Leaves;
import com.enercom.enercom.services.leaves.LeavesService;
import com.enercom.enercom.services.leaves.SaveLeavesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeavesController {
    private LeavesService leavesService;

    public LeavesController(final LeavesService leavesService) {
        this.leavesService = leavesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leaves> get(@PathVariable int id) {
        var item = this.leavesService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Leaves> getAll() {
        return leavesService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveLeavesRequest request) {
        return leavesService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        leavesService.delete(id);
    }
}
