package org.acme.simplequarkusapps.vatcalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.simplequarkusapps.vatcalculator.models.Vat;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.acme.simplequarkusapps.vatcalculator.services.VatService;



@Path("/vat")
@Tag(name = "VAT  - Calculator (calculates vat parameters)", description = "calculates vat")
public class VatController {

    @Inject
    VatService vatService;

    @GET
    @Path("/rates-and-info")
    @Operation(summary = "shows vat rates and info", description = "shows vat rates and info.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public String vatInfo() {
        return vatService.vatRatesAndInfo();
    }

    @GET
    @Path("/amount")
    @Operation(summary = "calculates vat amount on goods and services", description = "calculates vat amount on goods and services in uganda.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateVatAmount(@QueryParam("netAmount") double taxableAmount) {
        return vatService.calculateVatAmount(taxableAmount);
    }

    @GET
    @Path("/taxable-amount")
    @Operation(summary = "calculates Taxable amount/net amount before vat additions", description = "calculates Taxable amount before vat A mount additions.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateTaxableAmount(@QueryParam("vatAmount") double vatAmount) {
        return vatService.calculateTaxableAmount(vatAmount);
    }

    @GET
    @Path("/total-amount")
    @Operation(summary = "calculates Total amount/gross amount ie Taxable amount plus Vat Amount", description = "calculates total amount ie Taxable amount plus vat amount.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateTotalAmount(@QueryParam("vatAmount") double vatAmount) {
        return vatService.calculateTotalAmount(vatAmount);
    }

    @POST
    @Path("/rate")
    @Operation(summary = "calculates the vat rate(%)", description = "calculates the vat rate(%) of the gross amount.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateVatRate(@QueryParam("netAmount") double taxableAmount, @QueryParam("vatAmount") double vatAmount) {
        return vatService.calculateVatRate(taxableAmount, vatAmount);
    }


}
