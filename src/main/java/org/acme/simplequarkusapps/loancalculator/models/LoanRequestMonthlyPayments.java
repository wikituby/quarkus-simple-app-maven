package org.acme.simplequarkusapps.loancalculator.models;

import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


public class LoanRequestMonthlyPayments {
    @NotNull
    @Schema(required = true, example = "120000")
    private double principal;

    @NotNull
    @Schema(required = true, example = "10")
    private double rate;
    @NotNull
    @Schema(required = true, example = "3")
    private int intervalOption;
    @NotNull
    @Schema(required = true, example = "2")
    private int time;


    public double getPrincipal() {
        return principal;
    }
    public void setPrincipal(double principal){
        this.principal = principal;
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