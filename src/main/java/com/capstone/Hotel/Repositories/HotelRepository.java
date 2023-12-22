package com.capstone.Hotel.Repositories;

import com.capstone.Hotel.DTOs.RequestBodyDTO;
import com.capstone.Hotel.Entities.HotelDetail;
import com.capstone.Hotel.Entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    @Query(value = "SELECT new com.capstone.Hotel.Entities.HotelDetail(h.hotel_id, h.hotel_name, h.hotel_address, h.hotel_description, h.star_rating, atc.file_url, fac.facility_name) FROM Hotels h\n" +
            "INNER JOIN HotelAttachment hatc ON hatc.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hatc.attachment_id\n" +
            "INNER JOIN HotelFacilities hofa ON hofa.id_hotel = h.hotel_id\n" +
            "INNER JOIN Facilities fac ON fac.facility_id = hofa.id_facility\n" +
            "WHERE h.hotel_id = ?1")
    List<HotelDetail> getDetailHotel(Integer hotelId);
    @Modifying
    @Query(value = "INSERT INTO hotels(hotel_name, hotel_description, hotel_contract_number, hotel_address, hotel_city, hotel_country, hotel_email, check_in_time, check_out_time)" +
            "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void addHotelRepo(String hotelName, String hotelDescribe, String phoneNumber, String hotelAddress, String hotelCity, String hotelCountry, String hotelEmail, LocalDate checkInTime, LocalDate checkOutTime);
}
