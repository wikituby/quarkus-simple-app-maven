package org.acme.simplequarkusapps.vatcalculator.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.vatcalculator.models.Vat;

@ApplicationScoped
public class VatService {

    public String calculateVatAmount(double taxableAmount) {
        Vat vatObj = new Vat();
        vatObj.setTaxableAmount(taxableAmount);
        vatObj.calculateVatAmount();
        return String.format("Vat Amount = %.2f UGX", vatObj.getVatAmount());
    }

    public String calculateVatRate(double taxableAmount, double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setTaxableAmount(taxableAmount);
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateVatRate();
        return String.format("VAT Rate = %.2f ", vatObj.getVatRate());
    }

    public String calculateTaxableAmount(double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateTaxableAmount();
        return String.format("Taxable Amount: %.2f UGX", vatObj.getTaxableAmount());
    }

    public String calculateTotalAmount(double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateTotalAmount();
        return String.format("Total Amount = %.2f UGX", vatObj.getTotalAmount());
    }

    public String vatInfo() {
        Vat vatObj = new Vat();
        return vatObj.getVatInfo();
    }
}
