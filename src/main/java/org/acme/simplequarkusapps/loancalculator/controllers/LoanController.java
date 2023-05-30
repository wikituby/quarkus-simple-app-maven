package org.acme.simplequarkusapps.loancalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.acme.simplequarkusapps.loancalculator.services.LoanService;

//@Path("/loan")
@Tag(name = "Loan  - Calculator", description = "This will calculate interest in any time period given")
public class LoanController {

    @Inject
    LoanService loanService;

    @GET
    //@Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculatePrincipal(@QueryParam("rate") double rate, @QueryParam("amount") double amount, @QueryParam("time") int time, @QueryParam("intervalOption") int intervalOption) {
        loanService.deliverPrincipal(rate, amount);
        loanService.getLoanTime(intervalOption, time);
        return loanService.calculatePrincipal();

    }

    @GET
   // @Path("/rate")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateRate(@QueryParam("amountBorrowed") double amountBorrowed, @QueryParam("amount") double amount, @QueryParam("time") double time, @QueryParam("intervalOption") int intervalOption) {
        return loanService.calculateRate(amountBorrowed, amount, time, intervalOption);
    }

}
