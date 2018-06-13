package com.akshay.crop_app.services;

/**
 * Created by Akshay on 17-04-2018.
 */

public class Rates {

    public String crop_name;
    public String rate;
    public String place;


    public Rates(){
        //this constructor is required
    }

    public Rates(String crop_name, String rate, String place) {
        this.crop_name = crop_name;
        this.rate = rate;
        this.place = place;

    }

    public String getCrop_name() {
        return crop_name;
    }

    public String getRate() {
        return rate;
    }

    public String getPlace() {
        return place;
    }

}
