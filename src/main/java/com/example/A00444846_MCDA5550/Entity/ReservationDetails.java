package com.example.A00444846_MCDA5550.Entity;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.List;

@Entity
public class ReservationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int hotel_id;
    private String checkin;
    private String checkout;
    @OneToMany(targetEntity = GuestDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private List<GuestDetails> guestDetails;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public List<GuestDetails> getGuestDetails() {
        return guestDetails;
    }

    public void setGuestDetails(List<GuestDetails> guestDetails) {
        this.guestDetails = guestDetails;
    }
}