package com.javatraining.jooleprojectteam2.Entity;

import javax.persistence.*;

@Entity
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int technicalDetailId;

    @OneToOne(mappedBy="technicalDetail",
            cascade={CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY)
    private Product product;

    // dummy fields
    private int airflow;
    private int maxPower;
    private int soundAtMaxSpeed;
    private int fanSweepDiameter;
    private int height;

    // constructors
    public TechnicalDetail(Product product, int airflow, int maxPower, int soundAtMaxSpeed, int fanSweepDiameter, int height) {
        this.product = product;
        this.airflow = airflow;
        this.maxPower = maxPower;
        this.soundAtMaxSpeed = soundAtMaxSpeed;
        this.fanSweepDiameter = fanSweepDiameter;
        this.height = height;
    }

    public TechnicalDetail() {

    }

    // getter and setters
    public int getTechnicalDetailId() {
        return technicalDetailId;
    }

    public void setTechnicalDetailId(int technicalDetailId) {
        this.technicalDetailId = technicalDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAirflow() {
        return airflow;
    }

    public void setAirflow(int airflow) {
        this.airflow = airflow;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getSoundAtMaxSpeed() {
        return soundAtMaxSpeed;
    }

    public void setSoundAtMaxSpeed(int soundAtMaxSpeed) {
        this.soundAtMaxSpeed = soundAtMaxSpeed;
    }

    public int getFanSweepDiameter() {
        return fanSweepDiameter;
    }

    public void setFanSweepDiameter(int fanSweepDiameter) {
        this.fanSweepDiameter = fanSweepDiameter;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "TechnicalDetail{" +
                "technicalDetailId=" + technicalDetailId +
                ", product=" + product +
                ", airflow=" + airflow +
                ", maxPower=" + maxPower +
                ", soundAtMaxSpeed=" + soundAtMaxSpeed +
                ", fanSweepDiameter=" + fanSweepDiameter +
                ", height=" + height +
                '}';
    }
}
