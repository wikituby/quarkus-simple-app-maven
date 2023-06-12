package org.acme.simplequarkusapps.nssfcalculator.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class NssfRequestContributions {

    //fields
    @Schema(required = true, example = "1000000")
    private double grossPay;

    //constructors


    //getters anf setters

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }


}
