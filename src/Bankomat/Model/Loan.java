package Bankomat.Model;

import Bankomat.Model.Admin;

import java.sql.Date;

public class Loan {
    private int id;
    private int startAmount;
    private int paidAmount;
    private double interestRate;
    private String paymentPlan;

    public Loan(int id, int startAmount, int paidAmount, double interestRate, String paymentPlan) {
        this.id = id;
        this.startAmount = startAmount;
        this.paidAmount = paidAmount;
        this.interestRate = interestRate;
        this.paymentPlan = paymentPlan;
    }

    public int getId() {
        return id;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }
}
