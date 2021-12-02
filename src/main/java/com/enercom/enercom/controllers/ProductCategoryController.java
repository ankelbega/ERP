package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.ProductCategory;
import com.enercom.enercom.services.productCategory.ProductCategoryService;
import com.enercom.enercom.services.productCategory.SaveProductCategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    private ProductCategoryService productCategoryService;

    public ProductCategoryController(final ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> get(@PathVariable int id) {
        var item = this.productCategoryService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<ProductCategory> getAll() {
        return productCategoryService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveProductCategoryRequest request) {
        return productCategoryService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productCategoryService.delete(id);
    }
}
