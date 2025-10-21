package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // constructor
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // derived getters
    public double getTotalPay() {
        // calculate pay for regular hours, overtime rate, and overtime hours
        double regularPay = getRegularHours() * payRate;
        double overtimeRate = payRate * 1.5;
        double overtimePay = getOvertimeHours() * overtimeRate;
        return regularPay + overtimePay;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40.0);
    }

    public int getOvertimeHours() {
        if (hoursWorked > 40) {
            return (int) (hoursWorked - 40.0);
        } else {
            return (int) 0.0;
        }
    }
}
