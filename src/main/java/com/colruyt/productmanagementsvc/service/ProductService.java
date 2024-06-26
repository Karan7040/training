package com.colruyt.productmanagementsvc.service;

import com.colruyt.productmanagementsvc.model.dto.ProductDto;
import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;

public interface ProductService {
    ProductDto getProductDetails(String pid);

    boolean insertProduct(ProductDto productDto);

    void deleteProduct(String pid);

    boolean updateProduct(String pid, UpdateProductDto updateProductDto);
}
