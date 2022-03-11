package com.example.A00444846_MCDA5550.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true ,nullable = false)
    private String hotel_name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private Boolean availability;

    @OneToMany(targetEntity = ReservationDetails.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private List<ReservationDetails> reservationDetails;

    public Hotel() {
    }

    public Hotel(String hotel_name, int price, Boolean availability) {
        this.hotel_name = hotel_name;
        this.price = price;
        this.availability = availability;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public List<ReservationDetails> getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(List<ReservationDetails> reservationDetails) {
        this.reservationDetails = reservationDetails;
    }
}
