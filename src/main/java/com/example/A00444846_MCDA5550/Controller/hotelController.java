package com.example.A00444846_MCDA5550.Controller;

import com.example.A00444846_MCDA5550.AccessingData.hotelRepository;
import com.example.A00444846_MCDA5550.Entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class hotelController {

    @RequestMapping("/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("Welcome to Hotel Reservation System", HttpStatus.OK);
    }

    @Autowired
    private hotelRepository hotelRepository;

    @GetMapping("/getListOfHotels")
    public Iterable<Hotel> getListOfHotels(){
        return hotelRepository.findAll();
    }

    @RequestMapping(value = "/reservationConfirmation", method = RequestMethod.POST, consumes = "application/json")
    public String reservationConfirmation(Hotel hotel){
        hotelRepository.save(hotel);
        return "Success";
    }
}
