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

    // constructor
    public ProductType(Product product, String useType, String application, String mountingLocation, String accessories) {
        this.product = product;
        this.useType = useType;
        this.application = application;
        this.mountingLocation = mountingLocation;
        this.accessories = accessories;
    }

    public ProductType() {

    }

    // getter and setters
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getMountingLocation() {
        return mountingLocation;
    }

    public void setMountingLocation(String mountingLocation) {
        this.mountingLocation = mountingLocation;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId=" + productTypeId +
                ", product=" + product +
                ", useType='" + useType + '\'' +
                ", application='" + application + '\'' +
                ", mountingLocation='" + mountingLocation + '\'' +
                ", accessories='" + accessories + '\'' +
                '}';
    }
}
