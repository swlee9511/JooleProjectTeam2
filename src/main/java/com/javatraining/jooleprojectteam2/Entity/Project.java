package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date time_created;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date last_updated;

    // Projects have one User
    @ManyToOne
    @JoinColumn(name="owner", referencedColumnName="user_name")
    private User user;

    // Projects have set of products
    @OneToMany(mappedBy="project")
    Set<Project_Product> productSet = new HashSet<>();

    // Constructors
    public Project() {
    }

    public Project(int project_id, Date time_created, User user) {
        this.project_id = project_id;
        this.time_created = time_created;
        this.last_updated = time_created;
        this.user = user;
    }

    // Getter and Setters
    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Project_Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Project_Product> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + project_id +
                ", time_created=" + time_created +
                ", last_updated=" + last_updated +
                ", user=" + user +
                '}';
    }
}
