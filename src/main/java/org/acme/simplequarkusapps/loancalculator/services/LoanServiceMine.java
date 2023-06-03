package org.acme.simplequarkusapps.loancalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.loancalculator.models.LoanMine;

@ApplicationScoped
public class LoanServiceMine {
    public LoanMine calculateTotalInterestOverLoanSpan(double principal, double ratePerMonth, int loanTimeIntervals, int loanTime, int interval) {
        LoanMine loanObj = new LoanMine();
        loanObj.setPrincipal(principal);
        loanObj.setRatePerMonth(ratePerMonth);
        loanObj.setLoanTimeIntervals(loanTimeIntervals);
        loanObj.setLoanTime(loanTime);
        loanObj.setInterval(interval);
        loanObj.calculateTotalInterestOverLoanSpan();
        return loanObj;
    }

    public LoanMine calculateTest(String manInterval){
        LoanMine loanObj = new LoanMine();
        loanObj.setManInterval(manInterval);
        return loanObj;
    }

}
