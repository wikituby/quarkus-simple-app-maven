package org.acme.simplequarkusapps.loancalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.simplequarkusapps.loancalculator.models.Loan;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.acme.simplequarkusapps.loancalculator.services.LoanService;

@Path("/loan")
@Tag(name = "Loan  - Calculator", description = "This will calculate interest in any time period given")
public class LoanController {

    @Inject
    LoanService loanService;

    @GET
    @Path("/monthly-payments")
    @Operation(summary = "monthly-payments", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculateMonthlyPayments(
            @QueryParam("principal") double principal,
            @QueryParam("ratePerMonth") double ratePerMonth,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculateMonthlyPayments(principal,ratePerMonth, intervalOption, time );
    }
    @GET
    @Path("/rate-from-given-amount")
    @Operation(summary = "Rate from given Amount", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculateRateFromGivenAmount(
            @QueryParam("principal") double principal,
            @QueryParam("amount") double amount,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculateRateFromGivenAmount(principal,amount, intervalOption, time );
    }

    @GET
    @Path("/principal")
    @Operation(summary = "principal", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculatePrincipal(
            @QueryParam("rate per month(%)") double rate,
            @QueryParam("amount") double amount,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculatePrincipal(rate,amount, intervalOption, time );
    }

   /* @GET
    @Path("/time-option")
    @Operation(summary = "time-option", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeOption getLoanTime(
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.getLoanTime(intervalOption, time);
    }

    @GET
    @Path("/rate")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateRate(
            @QueryParam("amountBorrowed") double amountBorrowed,
            @QueryParam("amount") double amount,
            @QueryParam("time") double time,
            @QueryParam("intervalOption") int intervalOption) {
        return loanService.calculateRate(amountBorrowed, amount, time, intervalOption);
    }*/

}
