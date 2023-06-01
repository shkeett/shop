package com.fedshop.shop.service;

import com.fedshop.shop.entity.Product;
import com.fedshop.shop.exception.ProductNotFoundException;
import com.fedshop.shop.model.request.ProductDTO;
import com.fedshop.shop.model.response.ResponseProductDTO;

import java.util.List;

public interface ProductService {

    Product create(ProductDTO productDTO);

    Product update(ProductDTO productDTO, Long id) throws ProductNotFoundException;

    Product findProductById(Long id);

    List<Product> getAllProduct();

    void deleteProduct(Long id);
}
