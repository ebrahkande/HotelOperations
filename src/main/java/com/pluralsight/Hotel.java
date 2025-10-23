package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor - Creates hotel with no bookings
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor - Creates hotel with existing bookings
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Main Operational Method
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if ((bookedSuites + numberOfRooms) <= this.numberOfSuites) {
                bookedSuites += numberOfRooms;
                return true;
            } else {
                return false;
            }
        } else {
            if ((bookedBasicRooms + numberOfRooms) <= this.numberOfRooms) {
                bookedBasicRooms += numberOfRooms;
                return true;
            } else {
                return false;
            }
        }
    }

    // Derived Getters
    public int getAvailableSuites() {
        // Available = Total - Booked
        return numberOfSuites - bookedSuites;
    }


    public int getAvailableRooms() {
        // Available = Total - Booked
        return numberOfRooms - bookedBasicRooms;
    }

    // Standard Getters
    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }
}
