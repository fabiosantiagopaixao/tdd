package com.fabio.tdd.model;

import java.time.LocalDate;

public class BookingModel {

    private String id;
    private String reserName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numberGuests;

    public BookingModel() {
    }

    public BookingModel(String id, String reserName, LocalDate checkIn, LocalDate checkOut, int numberGuests) {
        this.id = id;
        this.reserName = reserName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberGuests = numberGuests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReserName() {
        return reserName;
    }

    public void setReserName(String reserName) {
        this.reserName = reserName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberGuests() {
        return numberGuests;
    }

    public void setNumberGuests(int numberGuests) {
        this.numberGuests = numberGuests;
    }
}
