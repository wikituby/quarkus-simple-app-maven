package org.acme.simplequarkusapps.loancalculator.models;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.loancalculator.statics.TimeInterval;

@ApplicationScoped
public class Loan {

    private double totalAmount;

    private double term; // in months

    private double rate;

    private double totalInterest;

    private double principal;

    private TimeOption timeOption;

    public double getTotalAmount() {

        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {

        this.totalAmount = totalAmount;
    }

    public double getTotalInterest() {

        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {

        this.totalInterest = totalInterest;
    }

    public double getPrincipal() {

        return principal;
    }

    public void setPrincipal(double principal) {

        this.principal = principal;
    }

    public double getRate() {

        return rate;
    }

    public void setRate(double rate) {

        this.rate = rate;
    }

    public double getTerm() {

        return term;
    }

    public void setTerm(double term) {

        this.term = term;
    }

    public TimeOption getTimeOption() {

        return timeOption;
    }

    public void setTimeOption(TimeOption timeOption) {

        this.timeOption = timeOption;
    }

    public void calculateLoanAmount() {

        this.term = calculateLoanTerm();
        this.totalInterest = this.principal * (this.rate * 0.01) * this.term;
        this.totalAmount = this.principal + this.totalInterest;
    }

    private double calculateLoanTerm() {

        TimeInterval interval = this.timeOption.getPeriod();
        double loanTerm = 0;
        switch (interval) {
            case YEARLY -> loanTerm = this.timeOption.getTime() * 12;
            case MONTHLY -> loanTerm = this.timeOption.getTime();
            case WEEKLY -> loanTerm = this.timeOption.getTime() / 4.345;
            case DAILY -> loanTerm = this.timeOption.getTime() / (4.345 * 7);
        }

        return loanTerm;
    }

    public void calculateRate() {

        this.term = calculateLoanTerm();
        if (this.term != 0) {
            this.rate = ((this.totalAmount - this.principal) / (this.principal * this.term)) * 100;
            this.totalInterest = this.totalAmount-this.principal;
        }
    }

    public void calculatePrincipal() {

        this.term = calculateLoanTerm();
        this.principal = this.totalAmount / ((this.rate * 0.01 * this.term) + 1);
        this.totalInterest = this.totalAmount-this.principal;

    }

}
