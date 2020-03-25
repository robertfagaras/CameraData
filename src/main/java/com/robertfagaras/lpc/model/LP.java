package com.robertfagaras.lpc.model;

public class LP {

    private int id;
    private String date;
    private String number;

    @Override
    public String toString() {
        return "LP{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

