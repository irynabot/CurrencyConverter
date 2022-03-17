package com.main.model;

public class Currency {
    String fullname;
    String shortname;
    Double rate;

    public Currency(String fullname,String shortname, Double rate)
    {
        this.fullname = fullname;
        this.shortname = shortname;
        this.rate = rate;
    }
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
