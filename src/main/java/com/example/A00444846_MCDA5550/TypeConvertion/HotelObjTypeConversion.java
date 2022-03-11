package com.example.A00444846_MCDA5550.TypeConvertion;

import com.example.A00444846_MCDA5550.Entity.Hotel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HotelObjTypeConversion {

    // Convert List<Hotel> to List<Map>
    public static List<Map<String, Object>> convertListToMap(List<Hotel> hotelList){
        List<Map<String, Object>> hotelListMap = new ArrayList<>();
        Map<String, Object> hotelMap;
        for (Hotel hotelObj: hotelList){
            hotelMap = new LinkedHashMap<>();
            hotelMap.put("hotel_name", hotelObj.getHotel_name());
            hotelMap.put("price", hotelObj.getPrice());
            hotelMap.put("availability", hotelObj.getAvailability());
            hotelListMap.add(hotelMap);
        }
        return hotelListMap;
    }
}
