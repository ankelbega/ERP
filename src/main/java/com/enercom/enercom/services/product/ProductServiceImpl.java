package com.enercom.enercom.services.product;

import com.enercom.enercom.domain.Product;
import com.enercom.enercom.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = productRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        productRepository.delete(item);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public int save(SaveProductRequest request) {
        var dbItem = productRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setTitle(request.getTitle());
            dbItem.get().setDescription(request.getDescription());
            dbItem.get().setType(request.getType());
            dbItem.get().setStock(request.getStock());
            productRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Product.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .stock(request.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        productRepository.save(newItem);
        return newItem.getId();
    }
}
