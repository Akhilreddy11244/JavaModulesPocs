package abstractpocs;
import java.util.*;

abstract class Loan {
    String customerName;
    double amount;
    int time;

    Loan(String customerName, double amount, int time) {
        this.customerName = customerName;
        this.amount = amount;
        this.time = time;
    }

    abstract double calculateInterestRate();
    abstract void displayLoanDetails();
}

class HomeLoan extends Loan {
    HomeLoan(String customerName, double amount, int time) {
        super(customerName, amount, time);
    }

    double calculateInterestRate() {
        return 8.5;
    }

    void displayLoanDetails() {
        double interest = (amount * (calculateInterestRate() * time)) / 100;
        System.out.println("\nHome Loan Details ");
        System.out.println("Customer: " + customerName);
        System.out.println("Amount: " + amount);
        System.out.println("Time: " + time + " years");
        System.out.println("Interest Rate: " + calculateInterestRate() + "%");
        System.out.println("Total Payable: " + (amount + interest));
    }
}

public class AbstractDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Loan Amount: ");
        double amt = sc.nextDouble();
        System.out.println("Enter Time (years): ");
        int yrs = sc.nextInt();

        Loan l = new HomeLoan(name, amt, yrs);
        l.displayLoanDetails();
    }
}
