package org.acme.simplequarkusapps.nssfcalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.simplequarkusapps.nssfcalculator.models.Nssf;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestContributions;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestGrossPay;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestNetPay;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.acme.simplequarkusapps.nssfcalculator.services.NssfService;


@Path("/nssf")
@Tag(name = "NSSF  - Calculator", description = "calculates nssf")
public class NssfController {

    @Inject
    NssfService nssfService;

    @GET
    @Path("/rates-and-info")
    @Operation(summary = "shows all the detailed info about NSSF Contributions", description = "This endpoint gives all the detailed info about NSSF.")
    @Produces(MediaType.APPLICATION_JSON)
    public String nssfRatesAndInfo() {
        return nssfService.nssfRatesAndInfo();
    }

    @POST
    @Path("/contributions")
    @Operation(summary = "This calculates nssf contributions for employee and employer", description = "This calculates nssf contributions for employee and employer and the total nssf contribution")
    @Produces(MediaType.APPLICATION_JSON)
    public Nssf calculateNssfContribution(NssfRequestContributions request) {
        return nssfService.calculateNssfContribution(request);

    }

    @POST
    @Path("/employee-gross-pay")
    @Operation(summary = "This calculates employees grossPay", description = "This calculates employees grossPay.")
    @Produces(MediaType.APPLICATION_JSON)
    public Nssf calculateGrossPay(NssfRequestGrossPay request) {
        return nssfService.calculateGrossPay(request);
    }

    @POST
    @Path("/employee-net-pay")
    @Operation(summary = "This calculates employees netPay after nssf deduction", description = "This calculates employees netPay after nssf deduction.")
    @Produces(MediaType.APPLICATION_JSON)
    public Nssf calculateNetPay(NssfRequestNetPay request) {
        return nssfService.calculateNetPay(request);
    }

}
