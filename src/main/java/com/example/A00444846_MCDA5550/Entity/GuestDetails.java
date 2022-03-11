package com.example.A00444846_MCDA5550.Entity;

import javax.persistence.*;

@Entity
public class GuestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int reservation_id;

    public GuestDetails(String guest_name, String gender, int reservation_id) {
        this.guest_name = guest_name;
        this.gender = gender;
        this.reservation_id = reservation_id;
    }

    @Column(nullable = false)
    private String guest_name;
    @Column(nullable = false)
    private String gender;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
