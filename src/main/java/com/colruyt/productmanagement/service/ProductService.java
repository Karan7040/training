package com.colruyt.productmanagement.service;

import com.colruyt.productmanagement.model.dto.ProductDto;

public interface ProductService {
    ProductDto  getProducts(String id);

    void insert(ProductDto productDto);

    void update(ProductDto productDto);

    void delete(String id);
}
