package com.fedshop.shop.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(schema = "fed", name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name_category")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="category_id", nullable=false)
    private List<Product> product;
}
