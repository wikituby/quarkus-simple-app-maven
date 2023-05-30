package org.acme.simplequarkusapps.nssfcalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.nssfcalculator.models.Nssf;

@ApplicationScoped
public class NssfService {

    public String nssfRatesAndInfo() {
        Nssf nssfObj = new Nssf();
        return nssfObj.getNssInfo();
    }

    public String calculateNssfContribution(double grossPay) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(grossPay);
        nssfObj.calculateNssfContribution();
        return String.format("Employee Nssf contribution = %.2f,Employer Nssf contribution = %.2f, Nssf total Contribution = %.2f,", nssfObj.getEmployeeNssfContribution(), nssfObj.getEmployerNssfContribution(), nssfObj.getNssfTotalContribution());
    }

    public String calculateGrossPay(double employerNssfContribution) {
        Nssf nssfObj = new Nssf();
        nssfObj.setEmployerNssfContribution(employerNssfContribution);
        nssfObj.calculateGrossPay();
        return String.format("GrossPay = %.2f", nssfObj.getGrossPay());
    }

    public String calculateNetPay(double grossPay) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(grossPay);
        nssfObj.calculateNetPay();
        return String.format("Employee NetPay = %.2f, Employee Nssf Contribution= %.2f,", nssfObj.getNetPay(), nssfObj.getEmployeeNssfContribution());
    }

}
