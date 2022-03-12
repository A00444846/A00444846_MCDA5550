package com.example.A00444846_MCDA5550.Controller;

import com.example.A00444846_MCDA5550.DbOperation.HotelRepository;
import com.example.A00444846_MCDA5550.DbOperation.ReservationDetailsRepository;
import com.example.A00444846_MCDA5550.ResponseType.ErrorResponse;
import com.example.A00444846_MCDA5550.TypeConvertion.HotelObjTypeConversion;
import com.example.A00444846_MCDA5550.DbOperation.InsertReservationAndGuestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class hotelController {

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Welcome to Hotel Reservation System", HttpStatus.OK);
    }

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;
    @Autowired
    private InsertReservationAndGuestDetails insertReservationDetails;

    @GetMapping("/getListOfHotels")
    public Map<String, List> getListOfHotels() {
        return new HashMap<>() {{
            put("hotels_list", HotelObjTypeConversion.convertListToMap(hotelRepository.getHotelList()));
        }};
    }

    @RequestMapping(value = "/reservationConfirmation", method = RequestMethod.POST, consumes = "application/json")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity reservationConfirmation(@RequestBody Map<String, Object> parameterMap) {

        if (parameterMap.get("hotel_name") == null || parameterMap.get("hotel_name").toString().trim().length() == 0) {
            return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "Paramater: hotel_name is required or can not be blank");
        }

        DateFormat DFormat = new SimpleDateFormat("MM/dd/yyyy");
        if (parameterMap.get("checkin") == null || parameterMap.get("checkin").toString().trim().length() == 0) {
            return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "Paramater: checkin is required or can not be blank");
        }else{
            try{
                DFormat.parse((String) parameterMap.get("checkin"));
            }catch (Exception e){
                return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "checkin date should be in MM/DD/YYYY");
            }
        }
        if (parameterMap.get("checkout") == null || parameterMap.get("checkout").toString().trim().length() == 0) {
            return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "Paramater: checkout is required or can not be blank");
        }else{
            try{
                DFormat.parse((String) parameterMap.get("checkout"));
            }catch (Exception e){
                return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "checkout date should be in MM/DD/YYYY");
            }
        }

        try {
            parameterMap.put("hotel_id", hotelRepository.getHotelId((String) parameterMap.get("hotel_name")));
        }catch (Exception e){
            return ErrorResponse.errorResponseEntity(HttpStatus.BAD_REQUEST, "Hotel name: "+ (String) parameterMap.get("hotel_name") + " not exist");
        }


        int confirmationNumber = insertReservationDetails.insertReservationAndGuestDetails(parameterMap);
        if(confirmationNumber == -1){
            ErrorResponse.errorResponseEntity(HttpStatus.FORBIDDEN, "Internal Error. Please Contact Admin");
        }
        Map<String, String> responseMap = new HashMap<>() {{
            put("confirmation_number", String.valueOf(confirmationNumber));
        }};
        return ErrorResponse.successResponseEntity(responseMap);
    }
}
