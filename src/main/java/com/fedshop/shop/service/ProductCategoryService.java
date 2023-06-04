package com.fedshop.shop.service;

import com.fedshop.shop.entity.ProductCategory;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.model.request.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory create(ProductCategoryDTO productCategoryDTO);

    ProductCategory update(ProductCategoryDTO productCategoryDTO, Long id) throws ProductNotFoundException;

    ProductCategory findProductCategoryById(Long id);

    List<ProductCategory> getAll();

    void deleteProductCategory(Long id);
}
