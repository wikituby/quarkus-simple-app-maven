package org.acme.simplequarkusapps.loancalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.loancalculator.models.Loan;
import org.acme.simplequarkusapps.loancalculator.models.TimeOption;
import org.acme.simplequarkusapps.loancalculator.statics.TimeInterval;


@ApplicationScoped
public class LoanService {

    private static void invalidOption() {

        System.out.println("\nInvalid option!");

    }

    public Loan calculateMonthlyPayments(double principal, double rate, int intervalOption, int time ) {
        Loan calculator = new Loan();
        calculator.setPrincipal(principal);
        calculator.setRate(rate);

        TimeOption timeOption = new TimeOption();

        switch (intervalOption) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(time);
        calculator.setTimeOption(timeOption);
        calculator.calculateLoanAmount();

        return calculator;
    }

    public Loan calculateRateFromGivenAmount(double principal, double amount, int intervalOption, int time ) {
        Loan calculator = new Loan();
        calculator.setPrincipal(principal);
        calculator.setAmount(amount);

        TimeOption timeOption = new TimeOption();

        switch (intervalOption) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(time);
        calculator.setTimeOption(timeOption);
        calculator.calculateRate();

        return calculator;
    }

    public Loan calculatePrincipal(double rate, double amount, int intervalOption, int time ) {
        Loan calculator = new Loan();
        calculator.setRate(rate);
        calculator.setAmount(amount);

        TimeOption timeOption = new TimeOption();

        switch (intervalOption) {
            case 1 -> timeOption.setPeriod(TimeInterval.YEARLY);
            case 2 -> timeOption.setPeriod(TimeInterval.MONTHLY);
            case 3 -> timeOption.setPeriod(TimeInterval.WEEKLY);
            case 4 -> timeOption.setPeriod(TimeInterval.DAILY);
            default -> invalidOption();
        }

        timeOption.setTime(time);
        calculator.setTimeOption(timeOption);
        calculator.calculatePrincipal();

        return calculator;
    }

}
