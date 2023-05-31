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

    /*public String vatInfo() {
        Vat vatObj = new Vat();
        return vatObj.getVatInfo();
    }*/

    public String vatInfo() {
        Vat vatObj = new Vat();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Create a JSON object with a single property
            Object json = objectMapper.createObjectNode().put("vatInfo", vatObj.getVatInfo());

            // Convert the JSON object to a formatted JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
