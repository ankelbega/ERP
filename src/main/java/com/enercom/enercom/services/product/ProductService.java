package com.enercom.enercom.services.product;

import com.enercom.enercom.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(int id);

    int save(SaveProductRequest request);

    void delete(int id);
}
