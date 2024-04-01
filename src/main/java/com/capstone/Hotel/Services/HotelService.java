package com.capstone.Hotel.Services;

import com.capstone.Hotel.DTOs.*;
import com.capstone.Hotel.Entities.HotelDetail;
import com.capstone.Hotel.Entities.Hotels;
import com.capstone.Hotel.Repositories.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
            List<ResponseFacility> facilitiesList = hotelRepository.listFacilities(hotelId);
            List<ResponseAttachment> attachmentList = hotelRepository.listAttachment(hotelId);

            Map<Integer, List<ResponseAttachment>> groupedAttachment = attachmentList.stream()
                    .collect(Collectors.groupingBy(ResponseAttachment::getHotel_id));

            Map<Integer, List<ResponseFacility>> groupedFacility = facilitiesList.stream()
                    .collect(Collectors.groupingBy(ResponseFacility::gethotel_id));

            Map<Integer, List<HotelDetail>> groupedHotel = data.stream()
                    .collect(Collectors.groupingBy(HotelDetail::getHotel_id));

            List<HotelDetail> transformedHotel = groupedHotel.values().stream()
                    .map(hotelsInGroup -> hotelsInGroup.get(0))
                    .collect(Collectors.toList());

            transformedHotel.forEach(i -> {
                var facilityListData = groupedFacility.get(i.getHotel_id());
                var attachmentListData = groupedAttachment.get(i.getHotel_id());
                i.setFacilities(facilityListData);
                i.setimages(attachmentListData);
            });

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

    public List<HotelDetail> suggestHotel(){
        List<Hotels> listHotels = hotelRepository.getAllHotel();
        List<HotelDetail> suggestList = new LinkedList<>();
        List<Integer> highestStarHotelId = getHighestStartHotelId(listHotels);

        for (Integer hotelId : highestStarHotelId){
            List<HotelDetail> data = hotelRepository.getDetailHotel(hotelId);

            List<ResponseAttachment> attachmentList = hotelRepository.listAttachment(hotelId);

            Map<Integer, List<ResponseAttachment>> groupedAttachment = attachmentList.stream()
                    .collect(Collectors.groupingBy(ResponseAttachment::getHotel_id));

            Map<Integer, List<HotelDetail>> groupedHotel = data.stream()
                    .collect(Collectors.groupingBy(HotelDetail::getHotel_id));

            List<HotelDetail> transformedHotel = groupedHotel.values().stream()
                    .map(hotelsInGroup -> hotelsInGroup.get(0))
                    .toList();

            transformedHotel.forEach(i -> {
                var attachmentListData = groupedAttachment.get(i.getHotel_id());
                i.setimages(attachmentListData);
            });
            suggestList.addAll(transformedHotel);
        }

        Collections.shuffle(suggestList);

        if (suggestList.size() < 5){
            return suggestList;
        }
        else{
            List<HotelDetail> randomSubset = suggestList.subList(0, 5);
            return randomSubset;
        }
    }

    private static List<Integer> getHighestStartHotelId(List<Hotels> listHotels) {
        List<Integer> highestStarHotelId = new LinkedList<>();

        Double highestRating = 0.0;

        // Search for the highest star rating number
        for(var i = 0; i < listHotels.size(); i++){
            if (listHotels.get(i).getStar_rating() >= listHotels.get(listHotels.size() - 1).getStar_rating()){
                highestRating = listHotels.get(i).getStar_rating();
            }
        }

        for (Hotels listHotel : listHotels) {
            if (Objects.equals(listHotel.getStar_rating(), highestRating)) {
                highestStarHotelId.add(listHotel.getHotel_id());
            }
        }
        return highestStarHotelId;
    }
}
