package com.emi;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private String loanId;
    private User user;
    private double loanAmount;
    private double interestRate;
    private int time; // in months
    private List<Double> paidEMIs;

    private Loan(String loanId, User user, double loanAmount, double interestRate, int time) {
        this.loanId = loanId;
        this.user = user;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.time = time;
        this.paidEMIs = new ArrayList<>();
    }

    // Helper method for object creation
    public static Loan createLoan(String loanId, User user, double loanAmount, double interestRate, int time) {
        return new Loan(loanId, user, loanAmount, interestRate, time);
    }

    public String getLoanId() {
        return loanId;
    }

    public User getUser() {
        return user;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTime() {
        return time;
    }

    public List<Double> getPaidEMIs() {
        return paidEMIs;
    }

    public void addPaidEMI(double amount) {
        this.paidEMIs.add(amount);
    }

    public double getRemainingAmount() {
        double totalPaid = paidEMIs.stream().mapToDouble(Double::doubleValue).sum();
        return loanAmount - totalPaid;
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId + ", User: " + user + ", Loan Amount: " + loanAmount +
               ", Interest Rate: " + interestRate + "%, Time: " + time + " months, Remaining Amount: " + getRemainingAmount();
    }
}
