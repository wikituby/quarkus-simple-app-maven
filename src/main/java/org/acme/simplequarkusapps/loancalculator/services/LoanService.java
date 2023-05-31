package org.acme.simplequarkusapps.loancalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.loancalculator.models.Loan;
import org.acme.simplequarkusapps.loancalculator.models.TimeOption;
import org.acme.simplequarkusapps.loancalculator.statics.TimeInterval;


@ApplicationScoped
public class LoanService {

    public void deliverPrincipal(double ratec, double amountc) {
        Loan loan = new Loan();
        loan.setRate(ratec);
        loan.setAmount(amountc);
        loan.calculatePrincipal();
        //return String.format("Principal = %.2f,", loan.getPrincipal());

    }
    public String printOut(){
        Loan loan = new Loan();
        return String.format("rate = %.2f, amount = %.2f", loan.getRate(), loan.getAmount());

    }

    public String customPrincipal(double rate, double interest) {
        Loan loan = new Loan();
        loan.setRate(rate);
        loan.setInterest(interest);
        loan.calculatePrincipalCustom();
        return String.format("Principal = %.2f,", loan.getPrincipal());

    }


    public TimeOption getLoanTime(int intervalOptionc, int timec) {

        TimeOption timeOption = new TimeOption();
        if(intervalOptionc==1){
            timeOption.setPeriod(TimeInterval.YEARLY);
        } else {
            if (intervalOptionc==2){
                timeOption.setPeriod(TimeInterval.MONTHLY);
            }else{
                if(intervalOptionc==3){
                    timeOption.setPeriod(TimeInterval.WEEKLY);
                }else {

                }

            }
        }
        switch (intervalOptionc) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> timeOption.getInvalidOption();
        }

        timeOption.setTime(timec);

        return timeOption;
    }
    public String calculatePrincipal(){
        Loan loan = new Loan();
        loan.calculatePrincipal();
        return String.format("Principal = %.2f,", loan.getPrincipal());

    }

    public String calculateRate(double amountBorrowed, double amount, double time, int intervalOption) {
        Loan loan = new Loan();
        loan.setPrincipal(amountBorrowed);
        loan.setAmount(amount);
        loan.calculateRate();
        return String.format("Rate Per Month = %.2f,", loan.getRate());

    }

    /*//calculating interest per month
    public String calculateInterest(double principal, double ratePerMonth, int interval, int time) {
        Loan loanObj = new Loan();
        loanObj.setPrincipal(principal);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.setYears(years);
        loanObj.setMonths(months);
        loanObj.setWeeks(weeks);
        loanObj.setDays(days);
        loanObj.calculateInterestPerMonths();
        loanObj.calculateInterestPerDays();
        loanObj.calculateInterestPerWeeks();
        loanObj.calculateInterestPerYears();
        loanObj.calculateTotalInterestInGivenPeriod();
        return String.format("Interest in a given period %.2f", loanObj.getTotalInterestInGivenPeriod());
        //return String.format("Interest period = %.2f, Interest per Month = %.2f, Interest per Day = %.2f, Interest per Week = %.2f", loanObj.getInterestPerYear(), loanObj.getInterestPerMonth(), loanObj.getInterestPerDay(), loanObj.getInterestPerWeek());

    }

   //calculating interest per day
    public String calculateInterestPerDay(double principal, double ratePerMonth) {
        Loan loanObj = new Loan();
        loanObj.setPrincipal(principal);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.calculateInterestPerDays();
        return String.format("Interest per Day = %.2f, Interest per Week = %.2f, Interest per Year = %.2f, Interest per Month = %.2f, ", loanObj.getInterestPerDay(), loanObj.getInterestPerWeek(), loanObj.getInterestPerYear(), loanObj.getInterestPerMonth());
    }

    //calculating interest per week new version
    public String calculateInterestPerWeek(double principal, double ratePerMonth) {
        Loan loanObj = new Loan();
        loanObj.setPrincipal(principal);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.calculateInterestPerWeeks();
        return String.format("Interest per Week = %.2f, Interest per Day = %.2f, Interest per Year = %.2f, Interest per Month = %.2f, ", loanObj.getInterestPerWeek(), loanObj.getInterestPerDay(), loanObj.getInterestPerYear(), loanObj.getInterestPerMonth());
    }

    //calculating interest per Year
    public String calculateInterestPerYear(double principal, double ratePerMonth) {
        Loan loanObj = new Loan();
        loanObj.setPrincipal(principal);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.calculateInterestPerYears();
        return String.format("Interest per Year = %.2f, Interest per Month = %.2f, Interest per Day = %.2f, Interest per Week = %.2f", loanObj.getInterestPerYear(), loanObj.getInterestPerMonth(), loanObj.getInterestPerDay(), loanObj.getInterestPerWeek());
    }

    //calculating rate per month
    public String calculateRatePerMonth(double interestPerMonth, double principal) {
        Loan loanObj = new Loan();
        loanObj.setInterestPerMonth(interestPerMonth);
        loanObj.setPrincipal(principal);
        loanObj.calculateRatePerMonth();
        return String.format("Rate per Month = %.2f", loanObj.getRatePerMonth());
    }

    //calculate amount to be borrowed
    public String calculatePrincipal(double interestPerMonth, double ratePerMonth) {
        Loan loanObj = new Loan();
        loanObj.setInterestPerMonth(interestPerMonth);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.calculatePrincipal();
        return String.format("Principal = %.2f", loanObj.getPrincipal());
    }
*/
}
