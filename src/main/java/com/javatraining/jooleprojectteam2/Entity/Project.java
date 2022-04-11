package com.javatraining.jooleprojectteam2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeCreated;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdated;

    // Projects have one User
    @JsonIgnore
    @ManyToOne (cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="owner", referencedColumnName="userName")
    private User user;

    // Projects have set of products
    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL},
               mappedBy="project")
    Set<ProjectProduct> productSet = new HashSet<>();

    // Constructors
    public Project() {
    }
    public Project(User user) {
        //this.timeCreated = new Date();
        //this.lastUpdated = new Date();
        this.user = user;
    }

    // Getter and Setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProjectProduct> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProjectProduct> productSet) {
        this.productSet = productSet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_id=" + projectId +
                ", time_created=" + timeCreated +
                ", last_updated=" + lastUpdated +
                ", user=" + user +
                '}';
    }
}
