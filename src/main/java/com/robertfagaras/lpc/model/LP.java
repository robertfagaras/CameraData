package com.robertfagaras.lpc.model;

public class LP {

    private int id;
    private String date;
    private String carNumber;

    @Override
    public String toString() {
        return "LP{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}

