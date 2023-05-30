package org.acme.simplequarkusapps.loancalculator.models;

import org.acme.simplequarkusapps.loancalculator.statics.TimeInterval;


public class TimeOption {

    private double time;
    private String invalidOption = "invalid Input";

    private TimeInterval period;

    public String getInvalidOption(){
        return invalidOption;
    }
    public void setInvalidOption(String invalidOption){
        this.invalidOption = invalidOption;
    }

    public TimeInterval getPeriod() {

        return period;
    }

    public void setPeriod(TimeInterval period) {

        this.period = period;
    }

    public double getTime() {

        return time;
    }

    public void setTime(double time) {

        this.time = time;
    }

}
