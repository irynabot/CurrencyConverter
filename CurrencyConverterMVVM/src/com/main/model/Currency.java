package com.main.model;

public class Currency {
    String name;
    Double rate;

    public Currency(String shortname, Double rate)
    {
        this.name = shortname;
        this.rate = rate;
    }

    public String getname() {
        return name;
    }

    public void setname(String shortname) {
        this.name = shortname;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
