package com.fedshop.shop.service.impl;

import com.fedshop.shop.entity.ProductCategory;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.mapper.ProductCategoryMapper;
import com.fedshop.shop.model.request.ProductCategoryDTO;
import com.fedshop.shop.repository.ProductCategoryRepository;
import com.fedshop.shop.service.ProductCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory create(@RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategoryMapper productCategoryMapper = new ProductCategoryMapper();
        ProductCategory productCategory = productCategoryMapper.productCategoryDtoToProductCategory(productCategoryDTO);
        ProductCategory createProduct = productCategoryRepository.save(productCategory);
        return createProduct;
    }

    @Override
    public ProductCategory update(@RequestBody ProductCategoryDTO productCategoryDTO, Long id) throws ProductNotFoundException {
        Optional<ProductCategory> productCategoryById = productCategoryRepository.findById(id);
        if (productCategoryById.isPresent()){
            ProductCategory productCategory = productCategoryById.get();
            productCategory.setName(productCategoryDTO.getName());
            ProductCategory updateCategoryProduct = productCategoryRepository.save(productCategory);
            return updateCategoryProduct;
        }
        throw new ProductNotFoundException("Category not found!");
    }

    @Override
    public ProductCategory findProductCategoryById(Long id) {
        Optional<ProductCategory> optional = productCategoryRepository.findById(id);
        ProductCategory productCategory = null;
        if (optional.isPresent()) {
            productCategory = optional.get();
        }
        return productCategory;
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.delete(findProductCategoryById(id));
    }
}
