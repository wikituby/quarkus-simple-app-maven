package org.acme.simplequarkusapps.nssfcalculator.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class NssfRequestNetPay {

    @Schema(required = true, example = "100000")
    private double grossPay;

    //getters anf setters
    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

}
