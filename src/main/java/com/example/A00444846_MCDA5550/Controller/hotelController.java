package com.example.A00444846_MCDA5550.Controller;

import com.example.A00444846_MCDA5550.DbOperation.HotelRepository;
import com.example.A00444846_MCDA5550.DbOperation.ReservationDetailsRepository;
import com.example.A00444846_MCDA5550.TypeConvertion.HotelObjTypeConversion;
import com.example.A00444846_MCDA5550.DbOperation.InsertReservationAndGuestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class hotelController {

    @RequestMapping("/")
    public ResponseEntity<String> index(){
        return new ResponseEntity<>("Welcome to Hotel Reservation System", HttpStatus.OK);
    }

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;
    @Autowired
    private InsertReservationAndGuestDetails insertReservationDetails;

    @GetMapping("/getListOfHotels")
    public Map<String, List> getListOfHotels(){
        return new HashMap<>() {{
            put("hotels_list", HotelObjTypeConversion.convertListToMap(hotelRepository.getHotelList()));
        }};
    }

    @RequestMapping(value = "/reservationConfirmation", method = RequestMethod.POST, consumes = "application/json")
    @Transactional(rollbackOn = Exception.class)
    public String reservationConfirmation(@RequestBody Map<String, Object> parameterMap){

        if(parameterMap.get("hotel_name") == null || parameterMap.get("hotel_name").toString().trim().length() == 0){

        }
            parameterMap.put("hotel_id", hotelRepository.getHotelId((String) parameterMap.get("hotel_name")));
            insertReservationDetails.insertReservationAndGuestDetails(parameterMap);
            return "Success";
    }
}
