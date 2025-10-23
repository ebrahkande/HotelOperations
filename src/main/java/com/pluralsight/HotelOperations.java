package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {
        System.out.println(" Hotel Operations Simulation ");

        // Testing Room
        System.out.println("\n*** 1. Hotel Inventory Test ***");

        // Create a hotel with 10 King Suites and 50 Basic Rooms
        Hotel majestic = new Hotel("The Majestic Grand", 10, 50);

        System.out.println("Hotel: " + majestic.getName());
        System.out.println("Initial Available Suites: " + majestic.getAvailableSuites());

        // Attempt to book 3 King Suites
        boolean success1 = majestic.bookRoom(3, true);
        System.out.println("Booking 3 Suites successful: " + success1);
        System.out.println("Current Available Suites: " + majestic.getAvailableSuites());

        // Attempt to book 55 Basic Rooms (should fail)
        boolean success2 = majestic.bookRoom(55, false);
        System.out.println("Booking 55 Basic Rooms successful: " + success2);
        System.out.println("Current Available Rooms: " + majestic.getAvailableRooms());


        // 2. Test Employee Time Card and Payroll
        System.out.println("\n*** 2. Employee Payroll Test (Overtime) ***");

        // Employee starts with 35 hours already worked this week
        Employee bob = new Employee("E300", "Bob Manager", "Operations", 25.00, 35.0);

        // Bob punches in for a new shift (Time 8.0 = 8:00 am)
        System.out.println(bob.punchTimeCard(8.0));

        // Bob punches out after 8 hours (Time 16.0 = 4:00 pm) - adds 8 hours
        System.out.println(bob.punchTimeCard(16.0));

        // Total Hours Worked: 35.0 + 8.0 = 43.0
        System.out.println("\nBob's Final Hours: " + bob.getHoursWorked());
        System.out.println("Regular Hours: " + bob.getRegularHours());   // 40.0
        System.out.println("Overtime Hours: " + bob.getOvertimeHours()); // 3.0

        // Total Pay: (40 * 25.00) + (3 * 25.00 * 1.5) = 1000 + 112.50 = 1112.50
        System.out.println("Bob's Total Pay: $" + String.format("%.2f", bob.getTotalPay()));


        // 3. Test Room State Management
        System.out.println("\n*** 3. Room State Test ***");
        Room room315 = new Room(1, 139.00, false, false); // Starts available

        System.out.println("Room 315 Available: " + room315.isAvailable());

        room315.checkIn(); // Occupied=true, Dirty=true -> Available=False
        System.out.println("Room 315 Available after Check-In: " + room315.isAvailable());

        room315.checkOut(); // Occupied=false, Dirty=true -> Available=False (still dirty)
        System.out.println("Room 315 Available after Check-Out: " + room315.isAvailable());

        room315.cleanRoom(); // Dirty=false -> Available=True
        System.out.println("Room 315 Available after Cleaning: " + room315.isAvailable());


        // 4. Test Reservation Pricing
        System.out.println("\n*** 4. Reservation Price Test ***");

        // Reservation: Double, 4 nights, Weekend (10% surcharge)
        Reservation res3 = new Reservation("Double", 4, true);
        // Base: $124.00 -> Weekend: $136.40 -> Total: $545.60
        System.out.println("Weekend Double Reservation Total: $" + String.format("%.2f", res3.getReservationTotal()));

    }
}
