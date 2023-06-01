package com.fedshop.shop.model.response;

import com.fedshop.shop.entity.ProductCategory;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductDTO {

    private Long id;
    private String name;
    private Double price;
    private ProductCategory category;
    private Integer count;
}
