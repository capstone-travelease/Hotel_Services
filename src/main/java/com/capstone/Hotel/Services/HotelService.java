package com.capstone.Hotel.Services;

import com.capstone.Hotel.DTOs.RequestBodyDTO;
import com.capstone.Hotel.DTOs.ResponseHotel;
import com.capstone.Hotel.DTOs.ResponseStatus;
import com.capstone.Hotel.Entities.HotelDetail;
import com.capstone.Hotel.Entities.Hotels;
import com.capstone.Hotel.Repositories.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public HotelDetail getDetailHotel(Integer hotelId){
        List<HotelDetail> data = hotelRepository.getDetailHotel(hotelId);

        if (data.isEmpty()){
            return null;
        }
        else{
            Map<Integer, List<HotelDetail>> groupedHotel = data.stream()
                    .collect(Collectors.groupingBy(HotelDetail::getHotel_id));

            List<HotelDetail> transformedHotel = groupedHotel.values().stream()
                    .map(roomsInGroup -> {
                        HotelDetail firstRoom = roomsInGroup.get(0);
                        List<String> facilities = roomsInGroup.stream()
                                .map(HotelDetail::getFacilities)
                                .collect(Collectors.toList());
                        firstRoom.setFacilities(facilities.toString());
                        return firstRoom;
                    })
                    .collect(Collectors.toList());
            return transformedHotel.get(0);
        }
    }

    @Transactional
    public ResponseStatus addHotel(RequestBodyDTO requestBody){
        hotelRepository.addHotelRepo(requestBody.getHotelName(), requestBody.getHotelDescription(), requestBody.getPhoneNumber(), requestBody.getHotelAddress(), requestBody.getHotelCity(), requestBody.getHotelCountry(), requestBody.getHotelEmail(), requestBody.getCheckInTime(), requestBody.getCheckOutTime());
        return new ResponseStatus(
                200,
                "Add hotel successful",
                "Successful"
        );
    }

    public ResponseStatus deleteHotel(Long hotelId){
        var checkId = hotelRepository.existsById(hotelId);
        if (checkId == false){
            return new ResponseStatus(
                    500,
                    "The hotel have an id " + hotelId +" does not existed !",
                    "Failure"
            );
        }
        else{
            hotelRepository.deleteById(hotelId);
            return new ResponseStatus(
                    200,
                    "Delete hotel " + hotelId +" successful",
                    "Successful"
            );
        }
    }

    public void updateHotel(){
    }
}
