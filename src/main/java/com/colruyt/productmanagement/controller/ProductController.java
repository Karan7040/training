package com.colruyt.productmanagement.controller;


import com.colruyt.productmanagement.model.dto.ProductDto;
import com.colruyt.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ProductController {
//todo: good used constructor injection
    private final ProductService productService;

    @GetMapping("/getProducts/{id}")
    public ProductDto getProductDto(@Valid @PathVariable("id")String id)
    {
return productService.getProducts(id);
    }
// todo: dont use generic return type.. on ResponseEntity
    @PostMapping("/insertProduct")
    public ResponseEntity  insertProduct(@RequestBody ProductDto productDto)
    {
        productService.insert(productDto);
       return new ResponseEntity<ProductDto> (HttpStatus.ACCEPTED);
    }
// todo: small case for urls
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
