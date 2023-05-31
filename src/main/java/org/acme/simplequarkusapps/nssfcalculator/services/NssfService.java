package org.acme.simplequarkusapps.nssfcalculator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.nssfcalculator.models.Nssf;

@ApplicationScoped
public class NssfService {

    public String nssfRatesAndInfo() {
        Nssf nssfObj = new Nssf();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Create a JSON object with a single property
            Object json = objectMapper.createObjectNode().put("nssInfo", nssfObj.getNssInfo());

            // Convert the JSON object to a formatted JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Nssf calculateNssfContribution(double grossPay) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(grossPay);
        nssfObj.calculateNssfContribution();
        return nssfObj;
    }

    public Nssf calculateGrossPay(double employerNssfContribution) {
        Nssf nssfObj = new Nssf();
        nssfObj.setEmployerNssfContribution(employerNssfContribution);
        nssfObj.calculateGrossPay();
        return nssfObj;
    }

    public Nssf calculateNetPay(double grossPay) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(grossPay);
        nssfObj.calculateNetPay();
        return nssfObj;
    }

}
