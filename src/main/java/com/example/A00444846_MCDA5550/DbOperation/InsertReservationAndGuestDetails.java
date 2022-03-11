package com.example.A00444846_MCDA5550.DbOperation;

import com.example.A00444846_MCDA5550.Entity.GuestDetails;
import com.example.A00444846_MCDA5550.Entity.ReservationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InsertReservationAndGuestDetails {
    @Autowired
    private ReservationDetailsRepository reservationDetailsRepository;

    @Autowired
    private GuestRepository guestRepository;

    public void insertReservationAndGuestDetails(Map<String, Object> parameterMap){
        ReservationDetails reservationDetailsObj = new ReservationDetails();

        reservationDetailsObj.setHotel_id((Integer) parameterMap.get("hotel_id"));
        reservationDetailsObj.setCheckin((String) parameterMap.get("checkin"));
        reservationDetailsObj.setCheckout((String) parameterMap.get("checkout"));
        ReservationDetails insertedReservationDetails =  reservationDetailsRepository.save(reservationDetailsObj);
//        System.out.println(insertedReservationDetails.toString());

        List<GuestDetails> guestDetailsObjList = new ArrayList<>();
        List<Map> guestMapList = (List<Map>) parameterMap.get("guests_list");
        GuestDetails guestDetailsObj;
        for(Map map : guestMapList){
            guestDetailsObj = new GuestDetails((String) map.get("guest_name"), (String) map.get("gender"), insertedReservationDetails.getId());
            guestDetailsObjList.add(guestDetailsObj);
        }
        guestRepository.saveAll(guestDetailsObjList);
    }
}
