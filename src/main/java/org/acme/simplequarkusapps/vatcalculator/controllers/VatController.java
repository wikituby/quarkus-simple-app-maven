package org.acme.simplequarkusapps.vatcalculator.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
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
    @Produces(MediaType.TEXT_PLAIN)
    public String vatInfo() {
        return vatService.vatInfo();
    }

    @GET
    @Path("/amount")
    @Operation(summary = "calculates vat amount on goods and services", description = "calculates vat amount on goods and services in uganda.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateVatAmount(@QueryParam("Taxable Amount") double taxableAmount) {
        return vatService.calculateVatAmount(taxableAmount);
    }

    @GET
    @Path("/taxable-amount")
    @Operation(summary = "calculates Taxable amount before vat additions", description = "calculates Taxable amount before vat A mount additions.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateTaxableAmount(@QueryParam("Vat Amount") double vatAmount) {
        return vatService.calculateTaxableAmount(vatAmount);
    }

    @GET
    @Path("/total-amount")
    @Operation(summary = "calculates Total amount ie Taxable amount plus Vat Amount", description = "calculates total amount ie Taxable amount plus vat amount.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateTotalAmount(@QueryParam("Vat Amount") double vatAmount) {
        return vatService.calculateTotalAmount(vatAmount);
    }

    @GET
    @Path("/rate")
    @Operation(summary = "calculates the vat rate(%)", description = "calculates the vat rate(%) of the gross amount.")
    @APIResponse(description = "Successful", responseCode = "200")
    @Produces(MediaType.APPLICATION_JSON)
    public Vat calculateVatRate(@QueryParam("Taxable Amount") double taxableAmount, @QueryParam("Vat Amount") double vatAmount) {
        return vatService.calculateVatRate(taxableAmount, vatAmount);
    }


}
