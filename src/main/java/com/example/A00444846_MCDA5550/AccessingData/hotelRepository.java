package com.example.A00444846_MCDA5550.AccessingData;

import com.example.A00444846_MCDA5550.Entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface hotelRepository extends CrudRepository<Hotel, Integer> {

    @Query (value = "SELECT new Hotel(hotel_name, price, availability) FROM Hotel")
    List<Hotel> getHotelList();
}
