package org.acme.simplequarkusapps.loancalculator.controllers;

import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.simplequarkusapps.loancalculator.handler.MessagesResponse;
import org.acme.simplequarkusapps.loancalculator.handler.ResponseMessage;
import org.acme.simplequarkusapps.loancalculator.models.LoanRequestMonthlyPayments;
import org.acme.simplequarkusapps.loancalculator.models.LoanRequestPrincipal;
import org.acme.simplequarkusapps.loancalculator.models.LoanRequestRate;
import org.acme.simplequarkusapps.loancalculator.services.LoanService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/loan")
@Tag(name = "Loan  - Calculator", description = "This will calculate interest in any time period given")
public class LoanControllerV4 {

    @Inject
    LoanService loanService;

    @POST
    @Path("/monthly-payments")
    @Operation(summary = "monthly-payments", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateMonthlyPayments(@NotNull LoanRequestMonthlyPayments request) {
        return Response.ok(new ResponseMessage(MessagesResponse.SAVED.label,
                loanService.calculateMonthlyPayments(request))).build();
    }
    @POST
    @Path("/rate-from-given-amount")
    @Operation(summary = "Rate from given Amount", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateRateFromGivenAmount(@NotNull LoanRequestRate requestRate) {
        return Response.ok(new ResponseMessage(MessagesResponse.SAVED.label,
                loanService.calculateRateFromGivenAmount(requestRate))).build();
    }
    @POST
    @Path("/principal")
    @Operation(summary = "principal", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculatePrincipal(@NotNull LoanRequestPrincipal request) {
        return Response.ok(new ResponseMessage(MessagesResponse.SAVED.label,
                loanService.calculatePrincipal(request))).build();
    }




    /*@GET
    @Path("/monthly-payments")
    @Operation(summary = "monthly-payments", description = "This will calculate interest in any time period given.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculateMonthlyPayments(
            @QueryParam("principal") double principal,
            @QueryParam("ratePerMonth") double ratePerMonth,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculateMonthlyPayments(principal,ratePerMonth, intervalOption, time );
    }*/
   /* @GET
    @Path("/rate-from-given-amount")
    @Operation(summary = "Rate from given Amount", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculateRateFromGivenAmount(
            @QueryParam("principal") double principal,
            @QueryParam("totalAmount") double totalAmount,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculateRateFromGivenAmount(principal,totalAmount, intervalOption, time );
    }

    @GET
    @Path("/principal")
    @Operation(summary = "principal", description = "Rate from given Amount.")
    @Produces(MediaType.APPLICATION_JSON)
    public Loan calculatePrincipal(
            @QueryParam("ratePerMonth(%)") double rate,
            @QueryParam("totalAmount") double totalAmount,
            @QueryParam("intervalOption") int intervalOption,
            @QueryParam("time") int time) {
        return loanService.calculatePrincipal(rate,totalAmount, intervalOption, time );
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
            @QueryParam("totalAmount") double totalAmount,
            @QueryParam("time") double time,
            @QueryParam("intervalOption") int intervalOption) {
        return loanService.calculateRate(amountBorrowed, totalAmount, time, intervalOption);
    }*/

}
