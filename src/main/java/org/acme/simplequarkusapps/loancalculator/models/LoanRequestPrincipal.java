package org.acme.simplequarkusapps.loancalculator.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class LoanRequestPrincipal {
    @Schema(required = true, example = "10")
    private double rate;
    @Schema(required = true, example = "2")
    private int intervalOption;
    @Schema(required = true, example = "2")
    private int time;
    @Schema(required = true, example = "1000000")
    private double totalAmount;


    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public double getRate() {
        return rate;
    }
    public void  setRate(double rate){
        this.rate = rate;
    }

    public int getIntervalOption() {
        return intervalOption;

    }
    public void setIntervalOption(int intervalOption){
        this.intervalOption = intervalOption;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}