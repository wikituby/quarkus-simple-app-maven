package org.acme.simplequarkusapps.nssfcalculator.models;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class NssfRequestGrossPay {

    @Schema(required = true, example = "100000")
    private double employerNssfContribution;
    //constructors


    //getters anf setters

    public double getEmployerNssfContribution() {
        return employerNssfContribution;
    }

    public void setEmployerNssfContribution(double employerNssfContribution) {
        this.employerNssfContribution = employerNssfContribution;
    }
}
