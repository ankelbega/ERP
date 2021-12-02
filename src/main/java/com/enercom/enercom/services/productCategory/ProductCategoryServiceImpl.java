package com.enercom.enercom.services.productCategory;

import com.enercom.enercom.domain.ProductCategory;
import com.enercom.enercom.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public Optional<ProductCategory> findById(int id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = productCategoryRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        productCategoryRepository.delete(item);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public int save(SaveProductCategoryRequest request) {
        var dbItem = productCategoryRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setTitle(request.getTitle());
            productCategoryRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = ProductCategory.builder()
                .title(request.getTitle())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        productCategoryRepository.save(newItem);
        return newItem.getId();
    }
}
