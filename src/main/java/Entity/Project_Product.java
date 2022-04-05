package Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project_Product {
    @Id
    private int project_productId; //PK

    @ManyToOne
    @JoinColumn(name="project_id", referencedColumnName="project_id")
    Project project;  //FK

    @ManyToOne
    @JoinColumn(name="resource_id", referencedColumnName="resource_id")
    Product product;  //FK

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeCreated;

    // Constructors
    public Project_Product() {
    }

    public Project_Product(int project_productId, Project project, Product product, Date timeCreated) {
        this.project_productId = project_productId;
        this.project = project;
        this.product = product;
        this.timeCreated = timeCreated;
    }

    // Getter and Setters
    public int getProject_productId() {
        return project_productId;
    }

    public void setProject_productId(int project_productId) {
        this.project_productId = project_productId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
