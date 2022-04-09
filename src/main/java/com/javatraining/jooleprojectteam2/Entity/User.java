package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {
    @Id
    private String userName;

    private String role;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdated;

    // User can have many projects
    @OneToMany(cascade={CascadeType.ALL},
               mappedBy="user")
    Set<Project> projectSets = new HashSet<>();

    // Constructors
    public User() {
    }

    public User(String userName, String role, String password) {
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.timeCreated = new Date();
        this.lastUpdated = new Date();
    }

    // Getter and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Set <Project> getProjectSets() {
        return projectSets;
    }

    public void setProjectSets(Set<Project> projectSets) {
        this.projectSets = projectSets;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", time_created=" + timeCreated +
                ", last_updated=" + lastUpdated +
                '}';
    }

}
