package com.capstone.Hotel.DTOs;

public class ResponseFacility {
    private Integer facility_id;
    private String facility_name;
    private Integer hotel_id;

    public ResponseFacility() {
    }
    public ResponseFacility(Integer facility_id, String facility_name) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
    }
    public ResponseFacility(Integer facility_id, String facility_name, Integer hotel_id) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.hotel_id = hotel_id;
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

    public Integer gethotel_id() {
        return hotel_id;
    }

    public void sethotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "ResponseFacility{" +
                "facility_id=" + facility_id +
                ", facility_name='" + facility_name +
                '}';
    }
}
