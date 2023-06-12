package org.acme.simplequarkusapps.loancalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.loancalculator.models.*;
import org.acme.simplequarkusapps.loancalculator.statics.TimeInterval;


@ApplicationScoped
public class LoanService {

    private static void invalidOption() {

        System.out.println("\nInvalid option!");

    }

    public Loan calculateMonthlyPayments(LoanRequestMonthlyPayments request ) {
        Loan calculator = new Loan();
        calculator.setPrincipal(request.getPrincipal());
        calculator.setRate(request.getRate());

        TimeOption timeOption = new TimeOption();

        switch (request.getIntervalOption()) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(request.getTime());
        calculator.setTimeOption(timeOption);
        calculator.calculateLoanAmount();

        return calculator;
    }

    public Loan calculateRateFromGivenAmount(LoanRequestRate requestRate ) {
        Loan calculator = new Loan();
        calculator.setPrincipal(requestRate.getPrincipal());
        calculator.setTotalAmount(requestRate.getTotalAmount());

        TimeOption timeOption = new TimeOption();

        switch (requestRate.getIntervalOption()) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(requestRate.getTime());
        calculator.setTimeOption(timeOption);
        calculator.calculateRate();

        return calculator;
    }

    public Loan calculatePrincipal(LoanRequestPrincipal request ) {
        Loan calculator = new Loan();
        calculator.setRate(request.getRate());
        calculator.setTotalAmount(request.getTotalAmount());

        TimeOption timeOption = new TimeOption();

        switch (request.getIntervalOption()) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(request.getTime());
        calculator.setTimeOption(timeOption);
        calculator.calculatePrincipal();

        return calculator;
    }

}
