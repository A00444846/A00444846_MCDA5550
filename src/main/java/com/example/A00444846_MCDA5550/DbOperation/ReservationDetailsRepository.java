package com.example.A00444846_MCDA5550.DbOperation;

import com.example.A00444846_MCDA5550.Entity.ReservationDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDetailsRepository extends CrudRepository<ReservationDetails, Integer> {

}
