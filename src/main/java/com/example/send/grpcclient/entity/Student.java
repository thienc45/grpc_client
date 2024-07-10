package com.example.send.grpcclient.entity;

public class Student {
    private double id;
    private double point;
    private String message;

    // Constructor
    public Student(double id, double point, String message) {
        this.id = id;
        this.point = point;
        this.message = message;
    }

    // Getters and setters (if needed)
    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
