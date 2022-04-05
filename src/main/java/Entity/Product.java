package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Product {
    @Id
    private int resource_id;

    // product_type_id FK

    // technical_detail_id FK

    // mechanical_detail_id FK

    private int model_year;
    private String brand;
    private String certification;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date time_created;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date last_updated;

    // products are in set of products
    @OneToMany(mappedBy="product")
    Set<Project_Product> productSet;

    // Constructors
    public Product() {
    }

    public Product(int resource_id, int model_year, String brand, String certification, Date time_created) {
        this.resource_id = resource_id;
        this.model_year = model_year;
        this.brand = brand;
        this.certification = certification;
        this.time_created = time_created;
        this.last_updated = time_created;
    }

    // Getter & Setters
    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int product_id) {
        this.resource_id = product_id;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
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
        return time_created;
    }

    public void setTimeCreated(Date timeCreated) {
        this.time_created = timeCreated;
    }

    public Date getLastUpdated() {
        return last_updated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.last_updated = lastUpdated;
    }

    public Set<Project_Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Project_Product> productSet) {
        this.productSet = productSet;
    }
}
