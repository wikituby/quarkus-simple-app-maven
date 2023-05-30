package org.acme.simplequarkusapps.loancalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.acme.simplequarkusapps.loancalculator.services.LoanService1;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;



@Path("/interest")
@Tag(name = "Loan  - Calculator", description = "This will calculate loan")
public class LoanController1 {

    @Inject
    LoanService1 loanService;

    @GET
    @Path("/interest-in-given-period")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.Make sure you provide the principal amount and the interest rate per month, then fill in the time or period, eg: how many months and weeks and days or years")
    @Produces(MediaType.TEXT_PLAIN)
    public String InterestInGivenPeriod(
            @QueryParam("principal") double principal,
            @QueryParam("ratePerMonth") double ratePerMonth,
            @QueryParam("Years") int years,
            @QueryParam("Months") int months,
            @QueryParam("Weeks") int weeks,
            @QueryParam("Days") int days)
    {
        return loanService.calculateInterest(principal, ratePerMonth, years, months, weeks, days);
    }
    @GET
    @Path("/principal")
    @Operation(summary = "calculate interest principal", description = "calculate principal ")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculatePrincipal(@QueryParam("interestPerMonth") double interestPerMonth, @QueryParam("ratePerMonth") double ratePerMonth){
        return loanService.calculatePrincipal(interestPerMonth, ratePerMonth);
    }

    @GET
    @Operation(summary = "calculate rate per month", description = "calculate principal ")
    @Path("/rate-per-month")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateRatePerMonth(@QueryParam("interestPerMonth") double interestPerMonth, @QueryParam("principal") double principal){
        return loanService.calculateRatePerMonth(interestPerMonth, principal);
    }
}