package com.fedshop.shop.model.request;

import com.fedshop.shop.entity.ProductCategory;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private Double price;
    private ProductCategory category;
    private Integer count;
}