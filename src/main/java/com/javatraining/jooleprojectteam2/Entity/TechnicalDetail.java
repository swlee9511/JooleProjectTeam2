package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;

@Entity
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int technicalDetailId;

    @OneToOne(mappedBy="technicalDetail",
            cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Product product;

    // dummy fields
    private int airflow;
    private int maxPower;
    private int soundAtMaxSpeed;
    private int fanSweepDiameter;
    private int height;

    public int getTechnicalDetailId() {
        return technicalDetailId;
    }

    public void setTechnicalDetailId(int technicalDetailId) {
        this.technicalDetailId = technicalDetailId;
    }
}
