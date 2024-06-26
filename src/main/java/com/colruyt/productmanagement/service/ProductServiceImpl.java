package com.colruyt.productmanagement.service;

import com.colruyt.productmanagement.model.dto.ProductDto;
import com.colruyt.productmanagement.model.entity.Products;
import com.colruyt.productmanagement.repository.ProductRepositoryJdbc;
import com.colruyt.productmanagement.repository.ProductsRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductsRepositoryJpa productsRepositoryJpa;
    private final ProductRepositoryJdbc productRepositoryJdbc;
    @Override
    public ProductDto getProducts(String id) {
        Products products=productsRepositoryJpa.findById(id).orElse(new Products());

        return ProductDto.builder()
                .pid(products.getPid())
                .pcode(products.getPcode())
                .pcost(products.getPcost())
                .pdisc(products.getPdisc())
                .pgst(products.getPgst())
                .build();
    }

    @Override
    public void insert(ProductDto productDto) {
        Products products=new Products();

        products.setPcode(productDto.getPcode());
        products.setPid(productDto.getPid());
        products.setPcost(productDto.getPcost());
        products.setPgst(productDto.getPgst());
        products.setPdisc(products.getPdisc());
productsRepositoryJpa.save(products);


    }

    @Override
    public void update(ProductDto productDto) {
        productRepositoryJdbc.updateName(productDto.getPid(),productDto.getPcode(),productDto.getPcost(), productDto.getPdisc(),productDto.getPgst());

    }

    @Override
    public void delete(String id) {
productRepositoryJdbc.deleteName(id);
    }
}
