package org.acme.simplequarkusapps.loancalculator.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class LoanRequestRate {
    @Schema(required = true, example = "100000")
    private double principal;
    @Schema(required = true, example = "3")
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
    public double getPrincipal() {
        return principal;
    }
    public void setPrincipal(double principal){
        this.principal = principal;
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