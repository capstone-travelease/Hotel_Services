package com.capstone.Hotel.DTOs;

public class ResponseAttachment {
    private String file_url;
    private Integer hotel_id;

    public ResponseAttachment() {
    }

    public ResponseAttachment( String file_url) {
        this.file_url = file_url;
    }

    public ResponseAttachment(String file_url, Integer hotel_id) {
        this.file_url = file_url;
        this.hotel_id = hotel_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "ResponseAttachment{" +
                ", file_url='" + file_url + '\'' +
                '}';
    }
}
