package org.acme.simplequarkusapps.nssfcalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
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
    @Produces(MediaType.TEXT_PLAIN)
    public String nssfRatesAndInfo() {
        return nssfService.nssfRatesAndInfo();
    }

    @GET
    @Path("/contributions")
    @Operation(summary = "This calculates nssf contributions for employee and employer", description = "This calculates nssf contributions for employee and employer and the total nssf contribution")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateNssfContribution(@QueryParam("grossPay") double grossPay) {
        return nssfService.calculateNssfContribution(grossPay);
    }

    @GET
    @Path("/employee-gross-pay")
    @Operation(summary = "This calculates employees grossPay", description = "This calculates employees grossPay.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateGrossPay(@QueryParam("employerNssfContribution") double employerNssfContribution) {
        return nssfService.calculateGrossPay(employerNssfContribution);
    }

    @GET
    @Path("/employee-net-pay")
    @Operation(summary = "This calculates employees netPay after nssf deduction", description = "This calculates employees netPay after nssf deduction.")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateNetPay(@QueryParam("grossPay") double grossPay) {
        return nssfService.calculateNetPay(grossPay);
    }

}
