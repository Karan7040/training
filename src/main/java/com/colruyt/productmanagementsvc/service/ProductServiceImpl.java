package com.colruyt.productmanagementsvc.service;

import com.colruyt.productmanagementsvc.exception.ProductNotFoundException;
import com.colruyt.productmanagementsvc.model.dto.ProductDto;
import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;
import com.colruyt.productmanagementsvc.model.entity.Product;
import com.colruyt.productmanagementsvc.repository.ProductJdbcRepository;
import com.colruyt.productmanagementsvc.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ProductServiceImpl implements ProductService {


    private ProductsRepository productsRepository;
    private ProductJdbcRepository productJdbcRepository;

    public ProductServiceImpl(ProductsRepository productsRepository, ProductJdbcRepository productJdbcRepository) {
        this.productsRepository = productsRepository;
        this.productJdbcRepository = productJdbcRepository;
    }

    @Transactional(rollbackFor = ProductNotFoundException.class)
    @Override
    public ProductDto getProductDetails(String pid) {
        Product product = productsRepository.findById(pid).orElseThrow(ProductNotFoundException::new);
        return ProductDto.builder().productCode(product.getPcode())
                .productCost(product.getPcost()).productGst(product.getPgst())
                .productDisc(product.getPdisc()).productId(product.getPid()).build();
    }


    @Override
    public boolean insertProduct(ProductDto productDto) {
        Product product = Product.builder().pcode(productDto.getProductCode()).pcost(productDto.getProductCost())
                .pdisc(productDto.getProductDisc()).pid(productDto.getProductId())
                .pgst(productDto.getProductGst()).build();
        int rowAffected = productJdbcRepository.insertProduct(product);
        return rowAffected > 0;
    }

    @Override
    public void deleteProduct(String pid) {
        productsRepository.deleteById(pid);

    }


    @Override
    public boolean updateProduct(String pid, UpdateProductDto updateProductDto) {
        int rowAffected = productJdbcRepository.updateProductWithPid(pid, updateProductDto);
        return rowAffected > 0;
    }


}
