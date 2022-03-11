package com.example.A00444846_MCDA5550.DbOperation;

import com.example.A00444846_MCDA5550.Entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query (value = "SELECT new Hotel(hotel_name, price, availability) FROM Hotel")
    List<Hotel> getHotelList();

    @Query(value = "SELECT id FROM Hotel Where hotel_name= ?1 limit 1", nativeQuery = true)
    int getHotelId(String hotel_name);
}
