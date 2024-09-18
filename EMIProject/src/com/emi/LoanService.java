package com.emi;

import java.util.HashMap;
import java.util.Map;

public class LoanService {
    private Map<String, Loan> loanMap = new HashMap<>();
    private String adminId = "admin123";

    // Method to create a loan
    public void createLoan(User user, double loanAmount, double interestRate, int time, String createdBy) {
        if (validateAdmin(createdBy)) {
            String loanId = generateLoanId();
            Loan loan = Loan.createLoan(loanId, user, loanAmount, interestRate, time);
            loanMap.put(loanId, loan);
        } else {
            System.out.println("Only admin can create loans!");
        }
    }

    // Validate if the creator is admin
    private boolean validateAdmin(String createdBy) {
        return adminId.equals(createdBy);
    }

    // Helper method to generate Loan ID
    private String generateLoanId() {
        return "LOAN" + Math.round(Math.random() * 10000);
    }

    // Method to calculate EMI
    public double calculateEMI(Loan loan) {
        double ratePerMonth = loan.getInterestRate() / (12 * 100);
        return (loan.getLoanAmount() * ratePerMonth * Math.pow(1 + ratePerMonth, loan.getTime())) / 
               (Math.pow(1 + ratePerMonth, loan.getTime()) - 1);
    }

    // Method to pay EMI
    public void payEMI(String loanId, double emiAmount) {
        Loan loan = loanMap.get(loanId);
        if (loan != null) {
            loan.addPaidEMI(emiAmount);
        } else {
            System.out.println("Loan not found!");
        }
    }

    // Admin method to view all loans
    public void viewAllLoans() {
        loanMap.values().forEach(System.out::println);
    }

    // Method to get loan details based on user ID
    public Loan getLoanDetails(String userId) {
        return loanMap.values().stream()
                .filter(loan -> loan.getUser().getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
