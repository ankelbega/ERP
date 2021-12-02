package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Supplier;
import com.enercom.enercom.services.supplier.SaveSupplierRequest;
import com.enercom.enercom.services.supplier.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> get(@PathVariable int id) {
        var item = this.supplierService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveSupplierRequest request) {
        return supplierService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierService.delete(id);
    }
}
