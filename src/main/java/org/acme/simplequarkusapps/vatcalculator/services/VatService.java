package org.acme.simplequarkusapps.vatcalculator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.nssfcalculator.models.Nssf;
import org.acme.simplequarkusapps.vatcalculator.models.Vat;

@ApplicationScoped
public class VatService {

    public Vat calculateVatAmount(double taxableAmount) {
        Vat vatObj = new Vat();
        vatObj.setTaxableAmount(taxableAmount);
        vatObj.calculateVatAmount();
        return vatObj;
    }

    public Vat calculateVatRate(double taxableAmount, double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setTaxableAmount(taxableAmount);
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateVatRate();
        return vatObj;
    }

    public Vat calculateTaxableAmount(double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateTaxableAmount();
        return vatObj;
    }

    public Vat calculateTotalAmount(double vatAmount) {
        Vat vatObj = new Vat();
        vatObj.setVatAmount(vatAmount);
        vatObj.calculateTotalAmount();
        return vatObj;
    }


}
