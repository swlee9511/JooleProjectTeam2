package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private String user_name;

    private String role;
    private String password;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date time_created;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date last_updated;

    // User can have many projects
    @OneToMany(mappedBy="user")
    Set<Project> projectSets = new HashSet<>();

    // Constructors
    public User() {
    }

    public User(String user_name, String role, String password, Date time_created) {
        this.user_name = user_name;
        this.role = role;
        this.password = password;
        this.time_created = time_created;
        this.last_updated = time_created;
    }

    // Getter and Setters
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<Project> getProjectSets() {
        return projectSets;
    }

    public void setProjectSets(Set<Project> projectSets) {
        this.projectSets = projectSets;
    }
}
