package com.capstone.Hotel.DTOs;

import com.capstone.Hotel.Entities.HotelDetail;

import java.util.List;

public class ResponseHotel {
    private Integer code;
    private HotelDetail data;
    private String message;

    public ResponseHotel() {
    }

    public ResponseHotel(Integer code, HotelDetail data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HotelDetail getData() {
        return data;
    }

    public void setData(HotelDetail data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
