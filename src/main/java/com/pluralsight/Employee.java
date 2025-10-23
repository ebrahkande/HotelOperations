package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;
    private double startTime;

    // Constructor
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = (int) hoursWorked;
        this.startTime = 0;
    }

    // Getters and Setters
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRegularHours() {
        /* returns the lesser of total hoursWorked or the 40.0 cap */
        return Math.min(hoursWorked, 40.0);
    }

    public double getOvertimeHours() {
        /* if hoursWorked is > 40, return the difference. Otherwise, return 0. */
        if (hoursWorked > 40) {
            return hoursWorked - 40.0;
        } else {
            return 0.0;
        }
    }

    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimeRate = payRate * 1.5;
        double overtimePay = getOvertimeHours() * overtimeRate;

        return regularPay + overtimePay;
    }

    // New method to capture time start
    public void punchIn(double time){
        this.startTime = time;
    }

    public void punchOut(double time){
        this.hoursWorked += (int) (time - this.startTime);
    }

    // Overload new method to capture time start
    public void punchOut(){
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + (now.getMinute() / 60.0);

        this.punchOut(currentTime);
    }

    public boolean punchTimeCard(double punchInTime){
        this.punchIn(punchInTime);
        double punchOutTime = 0;
        this.punchOut(punchOutTime);
        return false;
    }

}
