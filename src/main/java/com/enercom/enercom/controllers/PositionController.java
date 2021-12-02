package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Position;
import com.enercom.enercom.services.position.PositionService;
import com.enercom.enercom.services.position.SavePositionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/position")
public class PositionController {
    private PositionService positionService;

    public PositionController(final PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> get(@PathVariable int id) {
        var item = this.positionService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Position> getAll() {
        return positionService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SavePositionRequest request) {
        return positionService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        positionService.delete(id);
    }
}
