package com.colruyt.productmanagementsvc.controller;

import com.colruyt.productmanagementsvc.model.dto.ProductDto;
import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;
import com.colruyt.productmanagementsvc.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
// todo : use constructor
    @Autowired
    private ProductService productService;
// todo : we prefer having small case for urls
    @GetMapping("/Product/{pid}")
    public ResponseEntity<ProductDto> getProductDetails(@Valid @PathVariable("pid") String pid) {
// todo : good used.. response entity
        return new ResponseEntity<>(productService.getProductDetails(pid), HttpStatus.OK);
    }
// todo : dont use generic ResponseEntity, if no return type keep it Void

    // todo: keep @valid on ProductDto
    @PostMapping("/insertProduct")
    public ResponseEntity insertProduct(@RequestBody ProductDto productDto) {
        if (productService.insertProduct(productDto)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }
// todo : keep Void
    @DeleteMapping("/deleteProduct/{pid}")
    public ResponseEntity deleteProduct(@PathVariable("pid") String pid) {

        productService.deleteProduct(pid);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @PutMapping("/updateProduct/{pid}")
    public ResponseEntity updateProduct(@PathVariable("pid") String pid, UpdateProductDto updateProductDto) {
        if (productService.updateProduct(pid, updateProductDto)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
