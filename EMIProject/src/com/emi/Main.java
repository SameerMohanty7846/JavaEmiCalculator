package com.emi;

public class Main {
    public static void main(String[] args) {
        LoanService loanService = new LoanService();

        // Creating users
        User user1 = User.createUser("U001", "Sameer", false);
//        User user2 = User.createUser("U002", "John", false);
//        User user3 = User.createUser("U003", "Alice", false);

        // Admin creating loans for each user
        loanService.createLoan(user1, 500000, 7.5, 60, "admin123");  // Loan for Sameer
//        loanService.createLoan(user2, 300000, 8.0, 36, "admin123");  // Loan for John
//        loanService.createLoan(user3, 200000, 6.5, 24, "admin123");  // Loan for Alice

        // Display all loans (admin method)
        System.out.println("=== All Loans ===");
        loanService.viewAllLoans();

        // Calculate and display EMI for each loan
        Loan loan1 = loanService.getLoanDetails("U001");
//        Loan loan2 = loanService.getLoanDetails("U002");
//        Loan loan3 = loanService.getLoanDetails("U003");

        if (loan1 != null) {
            System.out.println("EMI for Sameer's Loan: " + loanService.calculateEMI(loan1));
        }

//        if (loan2 != null) {
//            System.out.println("EMI for John's Loan: " + loanService.calculateEMI(loan2));
//        }
//
//        if (loan3 != null) {
//            System.out.println("EMI for Alice's Loan: " + loanService.calculateEMI(loan3));
//        }

        // Paying some EMIs for each loan
        loanService.payEMI(loan1.getLoanId(), loanService.calculateEMI(loan1));
//        loanService.payEMI(loan2.getLoanId(), loanService.calculateEMI(loan2));
//        loanService.payEMI(loan3.getLoanId(), loanService.calculateEMI(loan3));

        // Display paid EMIs for each user
        System.out.println("=== Paid EMIs for Sameer ===");
        System.out.println(loan1.getPaidEMIs());

        System.out.println("=== Paid EMIs for John ===");
//        System.out.println(loan2.getPaidEMIs());

        System.out.println("=== Paid EMIs for Alice ===");
//        System.out.println(loan3.getPaidEMIs());

        // Admin checking all loans again with remaining amounts
        System.out.println("=== All Loans after EMI Payments (with Remaining Amount) ===");
        loanService.viewAllLoans();
    }
}
