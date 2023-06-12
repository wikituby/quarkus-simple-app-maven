package org.acme.simplequarkusapps.nssfcalculator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.simplequarkusapps.nssfcalculator.models.Nssf;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestContributions;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestGrossPay;
import org.acme.simplequarkusapps.nssfcalculator.models.NssfRequestNetPay;

@ApplicationScoped
public class NssfService {

    public String nssfRatesAndInfo() {
        Nssf nssfObj = new Nssf();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Create a JSON object with a single property
            Object json = objectMapper.createObjectNode().put("nssInfo", nssfObj.getNssInfo());
            //Convert the JSON object to a formatted JSON string
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            System.out.println(jsonString);
            return jsonString;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Nssf calculateNssfContribution(NssfRequestContributions request) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(request.getGrossPay());
        nssfObj.calculateNssfContribution();
        return nssfObj;
    }

    public Nssf calculateGrossPay(NssfRequestGrossPay request) {
        Nssf nssfObj = new Nssf();
        nssfObj.setEmployerNssfContribution(request.getEmployerNssfContribution());
        nssfObj.calculateGrossPay();
        return nssfObj;
    }

    public Nssf calculateNetPay(NssfRequestNetPay request) {
        Nssf nssfObj = new Nssf();
        nssfObj.setGrossPay(request.getGrossPay());
        nssfObj.calculateNetPay();
        return nssfObj;
    }

}
