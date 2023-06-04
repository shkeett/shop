package com.fedshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(schema = "fed", name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private Double price;
    private Integer count;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="category_id", nullable=false)
    private ProductCategory category;
}
