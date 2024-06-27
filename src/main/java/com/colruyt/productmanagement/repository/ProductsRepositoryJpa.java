package com.colruyt.productmanagement.repository;

import com.colruyt.productmanagement.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
// todo: ProductJpaRepository
@Repository
public interface ProductsRepositoryJpa extends JpaRepository<Products, String>, JpaSpecificationExecutor<Products> {

}