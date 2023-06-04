package com.fedshop.shop.mapper;

import com.fedshop.shop.entity.Product;
import com.fedshop.shop.model.request.ProductDTO;
import com.fedshop.shop.model.response.ResponseProductDTO;

public class ProductMapper {

    public Product productDtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(product.getCategory());
        product.setCount(productDTO.getCount());
        return product;
    }

    public ResponseProductDTO productToResponse(Product product) {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId(product.getId());
        responseProductDTO.setName(product.getName());
        responseProductDTO.setPrice(product.getPrice());
        responseProductDTO.setCount(product.getCount());
        return responseProductDTO;
    }
}
