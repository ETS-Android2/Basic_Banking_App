package com.example.basic_banking_app.model;

import android.util.Log;

public class Customers {
    private int id;
    private String name;
    private String amount;
    private String email;
    private int photo;
    public static double newmoney;

    public Customers(int id, String name, String amount, int photo) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.photo = photo;
    }

    public Customers() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getNewmoney() {
        Log.d("dbkaushal", "getEntermoney: money is    " + this.newmoney);
        return this.newmoney;
    }

    public void setNewmoney(double newmoney) {
        this.newmoney = newmoney;
        Log.d("dbkaushal", "setEntermoney: money is    " + this.newmoney);
        Log.d("dbkaushal", "setEntermoney: money is    " + newmoney);
    }

    public int getphoto() {
        return photo;
    }

    public void setphoto(int photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
