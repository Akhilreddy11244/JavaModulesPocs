package abstractpocs;
import java.util.*;

interface Payment {
    void makePayment(double amount);
}

class CreditCardPayment implements Payment {
    String cardHolder;
    String cardNumber;

    CreditCardPayment(String cardHolder, String cardNumber) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
    }

    public void makePayment(double amount) {
        System.out.println("\nProcessing Credit Card Payment...");
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount: " + amount);
        System.out.println("Transaction Successful!");
    }
}

class UPI implements Payment {
    String upiId;
    String name;

    UPI(String upiId, String name) {
        this.upiId = upiId;
        this.name = name;
    }

    public void makePayment(double amount) {
        System.out.println("\nProcessing UPI Payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Name: " + name);
        System.out.println("Amount: " + amount);
        System.out.println("Transaction Successful");
    }
}

public class InterfaceDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Payment Method:\n1. Credit Card\n2. UPI");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Payment Amount: ");
        double amt = sc.nextDouble();
        sc.nextLine(); 

        Payment p;

        if(choice == 1) {
            System.out.print("Enter Card Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Card Number: ");
            String cardNo = sc.nextLine();
            p = new CreditCardPayment(name, cardNo);
        } else {
            System.out.print("Enter UPI ID: ");
            String upiId = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            p = new UPI(upiId, name);
        }

        p.makePayment(amt);
    }
}
