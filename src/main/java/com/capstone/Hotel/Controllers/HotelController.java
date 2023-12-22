package com.capstone.Hotel.Controllers;

import com.capstone.Hotel.DTOs.ResponseHotel;
import com.capstone.Hotel.DTOs.ResponseStatus;
import com.capstone.Hotel.Entities.HotelDetail;
import com.capstone.Hotel.Entities.Hotels;
import com.capstone.Hotel.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/hotel")
public class HotelController {
    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/detail")
    public ResponseHotel GetDetailHotel(@RequestParam(name="hotelId", required = true) Integer hotelId){
        HotelDetail data = hotelService.getDetailHotel(hotelId);
        if (data == null){
            return new ResponseHotel(
              500,
                    null,
              "No data from hotel with id = " + hotelId
            );
        }
        else{
            return new ResponseHotel(
                    200,
                    data,
                    "Successful"
            );
        }
    }

    @PostMapping("/add")
    public ResponseStatus AddHotel(@RequestBody Hotels requestBodyDTO){
        return hotelService.addHotel(requestBodyDTO);
    }

    @DeleteMapping("/delete")
    public ResponseStatus DeleteHotel(@RequestParam(name="hotelId", required = true) Long hotelId){
        return hotelService.deleteHotel(hotelId);
    }
}
