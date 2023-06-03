package org.acme.simplequarkusapps.loancalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.simplequarkusapps.loancalculator.models.LoanMine;
import org.acme.simplequarkusapps.loancalculator.services.LoanServiceMine;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

//@Path("/loan")
@Tag(name = "LoanMine  - Calculator", description = "This will calculate interest in any time period given")
public class LoanControllerMine {

    @Inject
    LoanServiceMine loanServiceMine;

    @GET
    @Path("/interest")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public LoanMine calculateTotalInterestOverLoanSpan(
            @QueryParam("principal") double principal,
            @QueryParam("ratePerMonth(%)") double ratePerMonth,
            @QueryParam("loanTimeIntervals") int loanTimeIntervals,
            @QueryParam("LoanTime") int loanTime,
            @QueryParam("interval") int interval ) {
        return loanServiceMine.calculateTotalInterestOverLoanSpan(principal, ratePerMonth, loanTimeIntervals, loanTime, interval);

    }

    @GET
    @Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public LoanMine calculatePrincipal(
            @QueryParam("manInterval") String manInterval){
        return loanServiceMine.calculateTest(manInterval);

    }

    @GET
    @Path("/rate")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public LoanMine calculateRate(
            @QueryParam("manInterval") String manInterval){
        return loanServiceMine.calculateTest(manInterval);

    }
}
