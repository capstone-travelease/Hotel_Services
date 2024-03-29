package com.capstone.Hotel.Entities;

import com.capstone.Hotel.DTOs.ResponseAttachment;
import com.capstone.Hotel.DTOs.ResponseFacility;

import java.time.LocalDate;
import java.util.List;

public class HotelDetail {
    private Integer hotel_id;
    private String hotel_name;
    private String hotel_address;
    private String hotel_city;
    private String hotel_country;
    private String hotel_description;
    private Double star_rating;
    private List<ResponseAttachment> images;
    private List<ResponseFacility> facilities;
    private Double price;

    public HotelDetail() {
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country = hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating, Double price) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country = hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.price = price;
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating, List<ResponseAttachment> images) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country= hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.images = images;
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating, List<ResponseAttachment> images, List<ResponseFacility> facilities) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country= hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.images = images;
        this.facilities = facilities;
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating, List<ResponseAttachment> images, Double price) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country = hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.images = images;
        this.price = price;
    }

    public HotelDetail(Integer hotel_id, String hotel_name, String hotel_address, String hotel_city, String hotel_country, String hotel_description, Double star_rating, List<ResponseAttachment> images, List<ResponseFacility> facilities, Double price) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_city = hotel_city;
        this.hotel_country = hotel_country;
        this.hotel_description = hotel_description;
        this.star_rating = star_rating;
        this.images = images;
        this.facilities = facilities;
        this.price = price;
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

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_country() {
        return hotel_country;
    }

    public void setHotel_country(String hotel_country) {
        this.hotel_country = hotel_country;
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

    public List<ResponseAttachment> getimages() {
        return images;
    }

    public void setimages(List<ResponseAttachment> images) {
        this.images = images;
    }

    public List<ResponseFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<ResponseFacility> facilities) {
        this.facilities = facilities;
    }

    public Double getprice() {
        return price;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelDetail{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_address='" + hotel_address + '\'' +
                ", hotel_city='" + hotel_city + '\'' +
                ", hotel_country='" + hotel_country + '\'' +
                ", hotel_description='" + hotel_description + '\'' +
                ", star_rating=" + star_rating +
                ", images=" + images +
                ", facilities=" + facilities +
                ", price=" + price +
                '}';
    }
}
