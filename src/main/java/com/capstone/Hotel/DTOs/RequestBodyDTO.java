package com.capstone.Hotel.DTOs;

import java.time.LocalDate;
import java.util.List;

public class RequestBodyDTO {
    private String hotelName;
    private String hotelDescription;
    private String phoneNumber;
    private String hotelAddress;
    private String hotelCity;
    private String hotelCountry;
    private String hotelEmail;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;

    public RequestBodyDTO() {
    }

    public RequestBodyDTO(String hotelName, String hotelDescription, String phoneNumber, String hotelAddress, String hotelCity, String hotelCountry, String hotelEmail, LocalDate checkInTime, LocalDate checkOutTime) {
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.phoneNumber = phoneNumber;
        this.hotelAddress = hotelAddress;
        this.hotelCity = hotelCity;
        this.hotelCountry = hotelCountry;
        this.hotelEmail = hotelEmail;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDate getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
