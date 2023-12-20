package com.capstone.Hotel.Entities;

import java.time.LocalDate;

public class HotelDetail {
    private Integer hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_description;
    private Double star_rating;
    private String hotel_images;
    private String facilities;

    public HotelDetail() {
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_description, Double star_rating, String hotel_images, String facilities) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.hotel_images = hotel_images;
        this.facilities = facilities;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_description() {
        return hotel_description;
    }

    public void setHotel_description(String hotel_description) {
        this.hotel_description = hotel_description;
    }

    public Double getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Double star_rating) {
        this.star_rating = star_rating;
    }

    public String getHotel_images() {
        return hotel_images;
    }

    public void setHotel_images(String hotel_images) {
        this.hotel_images = hotel_images;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "HotelDetail{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_address='" + hotel_address + '\'' +
                ", hotel_description='" + hotel_description + '\'' +
                ", star_rating=" + star_rating +
                ", hotel_images='" + hotel_images + '\'' +
                ", facilities='" + facilities + '\'' +
                '}';
    }
}
