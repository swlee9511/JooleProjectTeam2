package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;

@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productTypeId;

    @OneToOne(mappedBy="productType",
              cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
              fetch = FetchType.LAZY)
    private Product product;

    // dummy fields
    private String useType;
    private String application;
    private String mountingLocation;
    private String accessories;

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }
}
