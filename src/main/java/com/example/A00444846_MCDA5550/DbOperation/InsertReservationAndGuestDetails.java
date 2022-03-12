package com.example.A00444846_MCDA5550.DbOperation;

import com.example.A00444846_MCDA5550.Entity.GuestDetails;
import com.example.A00444846_MCDA5550.Entity.ReservationDetails;
import com.example.A00444846_MCDA5550.ResponseType.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public int insertReservationAndGuestDetails(Map<String, Object> parameterMap) {
        try {
            ReservationDetails reservationDetailsObj = new ReservationDetails();

            reservationDetailsObj.setHotel_id((Integer) parameterMap.get("hotel_id"));
            reservationDetailsObj.setCheckin((String) parameterMap.get("checkin"));
            reservationDetailsObj.setCheckout((String) parameterMap.get("checkout"));
            ReservationDetails insertedReservationDetails = reservationDetailsRepository.save(reservationDetailsObj);
//          System.out.println(insertedReservationDetails.toString());

            try {
                List<GuestDetails> guestDetailsObjList = new ArrayList<>();
                if (parameterMap.get("guests_list") != null) {
                    List<Map> guestMapList = (List<Map>) parameterMap.get("guests_list");
                    for (Map map : guestMapList) {
                        guestDetailsObjList.add(new GuestDetails((String) map.get("guest_name"), (String) map.get("gender"), insertedReservationDetails.getId()));
                    }
                    guestRepository.saveAll(guestDetailsObjList);
                }
            } catch (Exception e) {
            } finally {
                return insertedReservationDetails.getId();
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
