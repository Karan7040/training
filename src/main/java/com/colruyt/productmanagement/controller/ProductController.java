package com.colruyt.productmanagement.controller;


import com.colruyt.productmanagement.model.dto.ProductDto;
import com.colruyt.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getProducts/{id}")
    public ProductDto getProductDto(@Valid @PathVariable("id")String id)
    {
return productService.getProducts(id);
    }

    @PostMapping("/insertProduct")
    public ResponseEntity  insertProduct(@RequestBody ProductDto productDto)
    {
        productService.insert(productDto);
       return new ResponseEntity<ProductDto> (HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto)
    {
        productService.update(productDto);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id")String id)
    {
        productService.delete(id);
        return  new ResponseEntity(HttpStatus.OK);
    }



}
