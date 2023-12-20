package com.capstone.Hotel.Repositories;

import com.capstone.Hotel.DTOs.RequestBodyDTO;
import com.capstone.Hotel.Entities.HotelDetail;
import com.capstone.Hotel.Entities.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Long> {
    @Query(value = "SELECT new com.capstone.Hotel.Entities.HotelDetail(h.hotel_id, h.hotel_name, h.hotel_address, h.hotel_description, h.star_rating, atc.file_url, fac.facility_name) FROM Hotels h\n" +
            "INNER JOIN HotelAttachment hatc ON hatc.hotel_id = h.hotel_id\n" +
            "INNER JOIN Attachment atc ON atc.attachment_id = hatc.attachment_id\n" +
            "INNER JOIN HotelFacilities hofa ON hofa.id_hotel = h.hotel_id\n" +
            "INNER JOIN Facilities fac ON fac.facility_id = hofa.id_facility\n" +
            "WHERE h.hotel_id = ?1",nativeQuery = true)
    List<HotelDetail> getDetailHotel(Integer hotelId);

}
