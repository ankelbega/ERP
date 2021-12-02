package com.enercom.enercom.services.productCategory;

import com.enercom.enercom.domain.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    List<ProductCategory> findAll();

    Optional<ProductCategory> findById(int id);

    int save(SaveProductCategoryRequest request);

    void delete(int id);
}
