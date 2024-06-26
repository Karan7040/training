package com.colruyt.productmanagementsvc.controller;

import com.colruyt.productmanagementsvc.model.dto.ProductDto;
import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;
import com.colruyt.productmanagementsvc.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/Product/{pid}")
    public ResponseEntity<ProductDto> getProductDetails(@Valid @PathVariable("pid") String pid)
    {

            return new ResponseEntity<>(productService.getProductDetails(pid), HttpStatus.OK);
    }

    @PostMapping("/insertProduct")
    public ResponseEntity insertProduct(@RequestBody ProductDto productDto)
    {
        if(productService.insertProduct(productDto))
        {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("/deleteProduct/{pid}")
    public ResponseEntity deleteProduct(@PathVariable("pid") String pid)
    {
        productService.deleteProduct(pid);
        return new ResponseEntity(HttpStatus.ACCEPTED);

    }

    @PutMapping("/updateProduct/{pid}")
     public ResponseEntity updateProduct(@PathVariable("pid") String pid, UpdateProductDto updateProductDto)
     {

         if(productService.updateProduct(pid,updateProductDto))
         {
             return new ResponseEntity(HttpStatus.ACCEPTED);
         }
         else
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);

     }


}
