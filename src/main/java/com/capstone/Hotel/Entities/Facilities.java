package com.capstone.Hotel.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Facilities {
    @Id
    private Integer facility_id;
    @Column(name = "facility_name")
    private String facility_name;
    @Column(name = "facility_type")
    private String facility_type;
    @Column(name = "facility_price")
    private String facility_price;

    public Facilities() {
    }

    public Facilities(Integer facility_id, String facility_name, String facility_type, String facility_price) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.facility_type = facility_type;
        this.facility_price = facility_price;
    }

    public Integer getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(Integer facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getFacility_price() {
        return facility_price;
    }

    public void setFacility_price(String facility_price) {
        this.facility_price = facility_price;
    }
}
