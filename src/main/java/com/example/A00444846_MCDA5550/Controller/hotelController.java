package com.example.A00444846_MCDA5550.Controller;

import com.example.A00444846_MCDA5550.AccessingData.hotelRepository;
import com.example.A00444846_MCDA5550.Entity.Hotel;
import com.example.A00444846_MCDA5550.TypeConvertion.HotelObjTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class hotelController {

    @RequestMapping("/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("Welcome to Hotel Reservation System", HttpStatus.OK);
    }

    @Autowired
    private hotelRepository hotelRepository;

    @GetMapping("/getListOfHotels")
    public List<Map<String, Object>> getListOfHotels(){
        return HotelObjTypeConversion.convertListToMap(hotelRepository.getHotelList());
    }

    @RequestMapping(value = "/reservationConfirmation", method = RequestMethod.POST, consumes = "application/json")
    public String reservationConfirmation(Object obj){
//        hotelRepository.save(hotel);
        return "Success";
    }
}
