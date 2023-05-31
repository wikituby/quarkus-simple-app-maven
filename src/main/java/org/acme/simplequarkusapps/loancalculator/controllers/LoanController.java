package org.acme.simplequarkusapps.loancalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.acme.simplequarkusapps.loancalculator.services.LoanService;

@Path("/loan")
@Tag(name = "Loan  - Calculator", description = "This will calculate interest in any time period given")
public class LoanController {

    @Inject
    LoanService loanService;

    @GET
    @Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculatePrincipal(
            @QueryParam("ratec") double ratec,
            @QueryParam("amountc") double amountc,
            @QueryParam("timec") int timec,
            @QueryParam("intervalOptionc") int intervalOptionc) {
        loanService.deliverPrincipal(ratec, amountc);
        loanService.getLoanTime(intervalOptionc, timec);
        return loanService.printOut();

    }
    @PUT
    @Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String samplePut(
            @QueryParam("ratec") double ratec,
            @QueryParam("amountc") double amountc,
            @QueryParam("timec") int timec,
            @QueryParam("intervalOptionc") int intervalOptionc) {
        loanService.deliverPrincipal(ratec, amountc);
        loanService.getLoanTime(intervalOptionc, timec);
        return loanService.printOut();

    }
    @DELETE
    @Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String sampleDelete(
            @QueryParam("ratec") double ratec,
            @QueryParam("amountc") double amountc,
            @QueryParam("timec") int timec,
            @QueryParam("intervalOptionc") int intervalOptionc) {
        loanService.deliverPrincipal(ratec, amountc);
        loanService.getLoanTime(intervalOptionc, timec);
        return loanService.printOut();

    }

    @POST
    @Path("/principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String samplePost(
            @QueryParam("ratec") double ratec,
            @QueryParam("amountc") double amountc,
            @QueryParam("timec") int timec,
            @QueryParam("intervalOptionc") int intervalOptionc) {
        loanService.deliverPrincipal(ratec, amountc);
        loanService.getLoanTime(intervalOptionc, timec);
        return loanService.printOut();

    }

    @GET
    @Path("/custom-principal")
    @Operation(summary = "calculate interest in a given period", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.TEXT_PLAIN)
    public String customPrincipal(
            @QueryParam("rate") double rate,
            @QueryParam("interest") double interest) {
        return loanService.customPrincipal(rate, interest);

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
    }

}
