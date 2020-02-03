package Bankomat.Model;

import Bankomat.Model.Admin;

import java.sql.Date;

public class Loan {
    private int id;
    private int startAmount;
    private int paidAmount;
    private double interestRate;
    private Date paymentPlan;
    private Admin admin;

    public Loan(int id, int startAmount, int paidAmount, double interestRate, Date paymentPlan, Admin admin) {
        this.id = id;
        this.startAmount = startAmount;
        this.paidAmount = paidAmount;
        this.interestRate = interestRate;
        this.paymentPlan = paymentPlan;
        this.admin = admin;
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

    public Date getPaymentPlan() {
        return paymentPlan;
    }

    public Admin getAdmin() {
        return admin;
    }
}
