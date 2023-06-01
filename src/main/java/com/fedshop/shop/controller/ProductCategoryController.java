package com.fedshop.shop.controller;

import com.fedshop.shop.entity.ProductCategory;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.model.request.ProductCategoryDTO;
import com.fedshop.shop.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getCategories() {
        return ResponseEntity.ok().body(productCategoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getCategorie(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(productCategoryService.findProductCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCategory> createCategory(@Valid @RequestBody ProductCategoryDTO productCategoryDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/category").toUriString());
        return ResponseEntity.created(uri).body(productCategoryService.create(productCategoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateCategory(@Valid @RequestBody ProductCategoryDTO productCategoryDTO, @PathVariable(name = "id") Long id) throws ProductNotFoundException {
        return ResponseEntity.ok().body(productCategoryService.update(productCategoryDTO, id));
    }

    @DeleteMapping("/{id}")
    public void deleteProductCategory(@PathVariable(name = "id") Long id)  {
        productCategoryService.deleteProductCategory(id);
    }

}
