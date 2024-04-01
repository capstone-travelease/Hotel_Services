package com.capstone.Hotel.Repositories;

import com.capstone.Hotel.DTOs.RequestBodyDTO;
import com.capstone.Hotel.DTOs.ResponseAttachment;
import com.capstone.Hotel.DTOs.ResponseFacility;
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
    @Query("SELECT h FROM Hotels h")
    List<Hotels> getAllHotel();
    @Query(value = "SELECT new com.capstone.Hotel.Entities.HotelDetail(h.hotel_id, h.hotel_name, h.hotel_address, h.hotel_city, h.hotel_country, h.hotel_description, h.star_rating, r.room_price) FROM Hotels h\n" +
            "INNER JOIN HotelAttachment hatc ON hatc.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hatc.attachment_id\n" +
            "INNER JOIN Rooms r ON r.hotel_id = h.hotel_id\n" +
            "WHERE h.hotel_id = ?1")
    List<HotelDetail> getDetailHotel(Integer hotelId);
    @Modifying
    @Query(value = "INSERT INTO hotels(hotel_name, hotel_description, hotel_contract_number, hotel_address, hotel_city, hotel_country, hotel_email, check_in_time, check_out_time)" +
            "VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
    void addHotelRepo(String hotelName, String hotelDescribe, String phoneNumber, String hotelAddress, String hotelCity, String hotelCountry, String hotelEmail, LocalDate checkInTime, LocalDate checkOutTime);

    @Query("SELECT new com.capstone.Hotel.DTOs.ResponseFacility(f.facility_id, f.facility_name, h.hotel_id, f.facility_image)FROM Facilities f\n" +
            "INNER JOIN HotelFacilities hf ON hf.id_facility = f.facility_id\n" +
            "INNER JOIN Hotels h ON h.hotel_id = hf.id_hotel\n" +
            "WHERE h.hotel_id = ?1")
    List<ResponseFacility> listFacilities(Integer hotelId);

    @Query("SELECT new com.capstone.Hotel.DTOs.ResponseAttachment(atc.file_url, h.hotel_id) FROM Attachment atc\n" +
            "INNER JOIN HotelAttachment hatc ON hatc.attachment_id = atc.attachment_id\n" +
            "INNER JOIN Hotels h ON h.hotel_id = hatc.hotel_id\n" +
            "WHERE h.hotel_id = ?1")
    List<ResponseAttachment> listAttachment(Integer hotelId);
}
