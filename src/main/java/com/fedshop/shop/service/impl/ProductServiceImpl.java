package com.fedshop.shop.service.impl;

import com.fedshop.shop.entity.Product;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.mapper.ProductMapper;
import com.fedshop.shop.model.request.ProductDTO;
import com.fedshop.shop.repository.ProductRepository;
import com.fedshop.shop.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(@RequestBody ProductDTO productDTO) {
        ProductMapper productMapper = new ProductMapper();
        Product product = productMapper.productDtoToProduct(productDTO);
        Product createProduct = productRepository.save(product);
        return createProduct;
    }

    @Override
    public Product update(@RequestBody ProductDTO productDTO, Long id) throws ProductNotFoundException {
        Optional<Product> productById = productRepository.findById(id);
        if (productById.isPresent()){
            Product product = productById.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setCount(productDTO.getCount());
//            product.setCategory(productDTO.getCategory());
            Product updateProduct = productRepository.save(product);
            return updateProduct;
        }
        throw new ProductNotFoundException("Product not found!");
    }

    @Override
    public Product findProductById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(findProductById(id));
    }
}
