package com.colruyt.productmanagementsvc.service;

import com.colruyt.productmanagementsvc.exception.ProductNotFoundException;
import com.colruyt.productmanagementsvc.model.dto.ProductDto;
import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;
import com.colruyt.productmanagementsvc.model.entity.Product;
import com.colruyt.productmanagementsvc.repository.ProductJdbcRepository;
import com.colruyt.productmanagementsvc.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ProductServiceImpl implements ProductService {
// todo : constructor pls
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductJdbcRepository productJdbcRepository;

    @Override
    public ProductDto getProductDetails(String pid) {
        Product product = productsRepository.findById(pid).orElseThrow(ProductNotFoundException::new);
        return ProductDto.builder().pinCode(product.getPcode())
                .pcost(product.getPcost()).pgst(product.getPgst())
                .pdisc(product.getPdisc()).pid(product.getPid()).build();
    }
// todo : why rollback when not thrown in method?
    @Transactional(rollbackFor = ProductNotFoundException.class)
    @Override
    public boolean insertProduct(ProductDto productDto) {
        Product product = Product.builder().pcode(productDto.getPinCode()).pcost(productDto.getPcost())
                .pdisc(productDto.getPdisc()).pid(productDto.getPid())
                .pgst(productDto.getPgst()).build();
        int rowAffected = productJdbcRepository.insertProduct(product);
        return rowAffected > 0;
    }

    @Override
    public void deleteProduct(String pid) {
        productsRepository.deleteById(pid);

    }

    @Transactional(rollbackFor = ProductNotFoundException.class)
    @Override
    public boolean updateProduct(String pid, UpdateProductDto updateProductDto) {
        int rowAffected = productJdbcRepository.updateProductWithPid(pid, updateProductDto);
        return rowAffected > 0;
    }


}
