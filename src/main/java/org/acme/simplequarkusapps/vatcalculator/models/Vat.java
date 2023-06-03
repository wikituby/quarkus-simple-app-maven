package org.acme.simplequarkusapps.vatcalculator.models;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Vat {

    // vatAmount fields
    private double taxableAmount;
    private double vatAmount;
    private double totalAmount;
    private double vatRate;
    private String currency = "UGX";
    public String vatInfo = """
            VAT Rates and General Info.
            VAT (Value Added Tax) is a consumption tax imposed on the sale of goods and services. The method for calculating VAT may vary depending on the country or region. Generally, VAT is calculated as a percentage of the price of the goods or services.             
            In Uganda, the Value Added Tax (vatAmount) is a consumption tax levied on the supply of goods and services. The standard vatAmount rate in Uganda is currently set at 18%. 
            """;

    // constructors
    public Vat() {
    }

    public Vat(double taxableAmount, double vatAmount, double totalAmount, double vatRate, String vatInfo, String currency) {
        this.taxableAmount = taxableAmount;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
        this.vatRate = vatRate;
        this.vatInfo = vatInfo;
        this.currency = currency;
    }

    // getters and setters
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVatInfo() {
        return vatInfo;
    }

    public void setVatInfo(String vatInfo) {
        this.vatInfo = vatInfo;
    }

    public double getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public double getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(double vatAmount) {
        this.vatAmount = vatAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    // calculations
    public void calculateVatAmount() {
        this.vatRate = 0.18;
        this.vatAmount = this.taxableAmount * this.vatRate;
        this.totalAmount = this.taxableAmount + this.vatAmount;
    }

    public void calculateVatRate() {
        this.vatRate = this.vatAmount / this.taxableAmount;
    }

    public void calculateTaxableAmount() {
        this.vatRate = 0.18;
        this.taxableAmount = this.vatAmount/this.vatRate;
        this.totalAmount = this.taxableAmount + this.vatAmount;

    }

    public void calculateTotalAmount() {
        this.vatRate = 0.18;
        this.totalAmount = this.taxableAmount + this.vatAmount;
    }
}