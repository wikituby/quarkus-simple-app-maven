package org.acme.simplequarkusapps.loancalculator.models;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Loan1 {

    private double principal;
    private double ratePerMonth;
    private double totalLoanAmount;

    private int years;
    private int months;
    private int weeks;
    private int days;

    private double interestPerDay;
    private double interestPerWeek;
    private double interestPerMonth;
    private double interestPerYear;

    private double interestPerDays;
    private double interestPerWeeks;
    private double interestPerMonths;
    private double interestPerYears;

    private double totalInterestInGivenPeriod;


    public Loan1() {
    }

    //Loan constructor
    public Loan1(
            double principal,
            double ratePerMonth,
            int years,
            int months,
            int weeks,
            int days,
            double totalLoanAmount,
            double interestPerDay,
            double interestPerWeek,
            double interestPerMonth,
            double interestPerYear,
            double interestPerDays,
            double interestPerWeeks, double interestPerMonths, double interestPerYears, double totalInterestInGivenPeriod) {
        this.principal = principal;
        this.ratePerMonth = ratePerMonth;
        this.totalLoanAmount = totalLoanAmount;

        this.interestPerDay = interestPerDay;
        this.interestPerWeek = interestPerWeek;
        this.interestPerMonth = interestPerMonth;
        this.interestPerYear = interestPerYear;

        this.interestPerDays = interestPerDays;
        this.interestPerWeeks = interestPerWeeks;
        this.interestPerMonths = interestPerMonths;
        this.interestPerYears = interestPerYears;

        this.days = days;
        this.weeks = weeks;
        this.months = months;
        this.years = years;

        this.totalInterestInGivenPeriod = totalInterestInGivenPeriod;

    }

    //get and set amountToBorrowed
    public double getTotalInterestInGivenPeriod() {
        return totalInterestInGivenPeriod;
    }

    public void setTotalInterestInGivenPeriod(double totalInterestInGivenPeriod) {
        this.totalInterestInGivenPeriod = totalInterestInGivenPeriod;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }


    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }
    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    //get and set amountToBePaidPerDay
    public double getInterestPerDay() {
        return interestPerDay;
    }

    public void setInterestPerDay(double interestPerDay) {
        this.interestPerDay = interestPerDay;
    }

    //get and set amountToBePaidPerWeek
    public double getInterestPerWeek() {
        return interestPerWeek;
    }

    public void setInterestPerWeek(double interestPerWeek) {
        this.interestPerWeek = interestPerWeek;
    }

    //get and set amountToBePaidPerMonth
    public double getInterestPerMonth() {
        return interestPerMonth;
    }

    public void setInterestPerMonth(double interestPerMonth) {
        this.interestPerMonth = interestPerMonth;
    }

    //get and set amountToBePaidPerYear
    public double getInterestPerYear() {
        return interestPerYear;
    }

    public void setInterestPerYear(double interestPerYear) {
        this.interestPerYear = interestPerYear;
    }

    //get and set amountToBePaidPerDays
    public double getInterestPerDays() {
        return interestPerDays;
    }

    public void setInterestPerDays(double interestPerDays) {
        this.interestPerDays = interestPerDays;
    }

    //get and set amountToBePaidPerWeeks
    public double getInterestPerWeeks() {
        return interestPerWeeks;
    }

    public void setInterestPerWeeks(double interestPerWeeks) {
        this.interestPerWeeks = interestPerWeeks;
    }

    //get and set amountToBePaidPerMonthCal
    public double getInterestPerMonths() {
        return interestPerMonths;
    }

    public void setInterestPerMonths(double interestPerMonths) {
        this.interestPerMonths = interestPerMonths;
    }

    //get and set amountToBePaidPerYears
    public double getInterestPerYears() {
        return interestPerYears;
    }

    public void setInterestPerYears(double interestPerYears) {
        this.interestPerYears = interestPerYears;
    }

    //get and set ratePerMonth
    public double getRatePerMonth() {
        return ratePerMonth;
    }

    public void setRatePerMonth(double ratePerMonth) {
        this.ratePerMonth = ratePerMonth;
    }


    //all interest calculations together
    public void CalculateAllInterestAttributes(){
        this.interestPerMonth = (this.ratePerMonth / 100) * this.principal;
        this.interestPerMonths = this.interestPerMonth * this.months;

        this.interestPerDay = this.interestPerMonth / 30;
        this.interestPerDays = this.interestPerDay * this.days;

        this.interestPerWeek = this.interestPerDay * 7;
        this.interestPerWeeks = this.interestPerWeek * this.weeks;

        this.interestPerYear = this.interestPerMonth * 12;
        this.interestPerYears = this.interestPerYear * this.years;

        this.totalInterestInGivenPeriod = this.interestPerDays + this.interestPerWeeks + this.interestPerMonths + this.interestPerYears;

        this.totalLoanAmount=this.principal+this.totalInterestInGivenPeriod;


    }


   /*
    public void calculateInterestPerMonths() {
        this.interestPerMonth = (this.ratePerMonth/100) * this.principal;
        this.interestPerMonths = this.interestPerMonth * this.months;
    }

    public void calculateInterestPerDays() {
        this.interestPerMonth = (this.ratePerMonth/100) * this.principal;
        this.interestPerDay = this.interestPerMonth / 30;
        this.interestPerDays = this.interestPerDay * this.days;
    }

    public void calculateInterestPerWeeks() {
        this.interestPerMonth = (this.ratePerMonth/100) * this.principal;
        this.interestPerDay = this.interestPerMonth / 30;
        this.interestPerWeek = this.interestPerDay * 7;
        this.interestPerWeeks = this.interestPerWeek * this.weeks;
    }

    public void calculateInterestPerYears() {
        this.interestPerMonth = (this.ratePerMonth/100) * this.principal;
        this.interestPerYear = this.interestPerMonth * 12;
        this.interestPerYears = this.interestPerYear * this.years;
    }

    public void calculateTotalInterestInGivenPeriod() {
        this.totalInterestInGivenPeriod = this.interestPerDays + this.interestPerWeeks + this.interestPerMonths + this.interestPerYears;
    }
*/
    public void calculatePrincipal() {
        this.principal = this.interestPerMonth / (this.ratePerMonth/100);
    }

    public void calculateRatePerMonth() {

        this.ratePerMonth = this.interestPerMonth / this.principal;
    }


}

