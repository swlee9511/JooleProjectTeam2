package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceId;
    // product_type_id FK

    // technical_detail_id FK

    // mechanical_detail_id
    // use ENUM

    private int modelYear;
    private String brand;
    private String certification;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdated;

    // products are in set of products
    @OneToMany(mappedBy="product")
    Set<ProjectProduct> productSet = new HashSet<>();

    // Constructors
    public Product() {
    }

    public Product(int modelYear, String brand, String certification) {
        this.modelYear = modelYear;
        this.brand = brand;
        this.certification = certification;
        this.timeCreated = new Date();
        this.lastUpdated = new Date();
    }

    // Getter & Setters
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<ProjectProduct> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProjectProduct> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "resource_id=" + resourceId +
                ", model_year=" + modelYear +
                ", brand='" + brand + '\'' +
                ", certification='" + certification + '\'' +
                ", time_created=" + timeCreated +
                ", last_updated=" + lastUpdated +
                '}';
    }
}
