package com.capstone.Hotel.DTOs;

import com.capstone.Hotel.Entities.HotelDetail;

import java.util.List;

public class ResponseListHotelDetail {
    private Integer code;
    private List<HotelDetail> data;
    private String message;

    public ResponseListHotelDetail(Integer code, List<HotelDetail> data, String message) {
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

    public List<HotelDetail> getData() {
        return data;
    }

    public void setData(List<HotelDetail> data) {
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
        return "ResponseSuggest{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
