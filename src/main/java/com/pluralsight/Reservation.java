package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    //  Constructor
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Getters and Setters
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getPrice() {
        // use an if-else if structure to determine the base price
        if (roomType.equalsIgnoreCase("king")) {
            return 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            return 124.0;
        } else {
            return 0.0;
        }
    }


public double getReservationTotal() {
        // get the base price for the room type
        double basePricePerNight = getPrice();
        double effectivePricePerNight = basePricePerNight;
        // check for the weekend surcharge condition
        if (isWeekend) {
            effectivePricePerNight = basePricePerNight * 1.10;
        }
        // calculate the final total
        double total = effectivePricePerNight * numberOfNights;
        return total;
    }
}
