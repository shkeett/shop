package com.fedshop.shop.mapper;

import com.fedshop.shop.entity.ProductCategory;
import com.fedshop.shop.model.request.ProductCategoryDTO;
import com.fedshop.shop.model.response.ResponseProductCategoryDTO;

public class ProductCategoryMapper {

    public ProductCategory productCategoryDtoToProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryDTO.getName());
        return productCategory;
    }

    public ResponseProductCategoryDTO productCategoryToResponse(ProductCategory productCategory) {
        ResponseProductCategoryDTO responseProductCategoryDTO = new ResponseProductCategoryDTO();
        responseProductCategoryDTO.setId(productCategory.getId());
        responseProductCategoryDTO.setName(productCategory.getName());
        return responseProductCategoryDTO;
    }
}
