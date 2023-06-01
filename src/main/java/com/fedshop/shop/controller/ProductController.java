package com.fedshop.shop.controller;

import com.fedshop.shop.entity.Product;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.model.request.ProductDTO;
import com.fedshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/product").toUriString());
        return ResponseEntity.created(uri).body(productService.create(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@Valid @RequestBody ProductDTO productDTO, @PathVariable(name = "id") Long id) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productService.update(productDTO, id));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id)  {
        productService.deleteProduct(id);
    }
}