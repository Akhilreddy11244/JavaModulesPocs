package abstractpocs;

import java.util.*;

interface ATM {
    void withdraw(double amt);
    void checkBalance();
}

class SBIATM implements ATM {
    double balance = 5000;

    public void withdraw(double amt) {
        if(amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

	public void addAmount(double addAmt) {
		// TODO Auto-generated method stub
		balance += addAmt;
		
	}
}

public class InterfaceDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SBIATM atm = new SBIATM();
        while(true) {
            System.out.println("\n1. Withdraw\n2. Check Balance\n3. Add Amount\n4. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            if(ch == 4) {
                System.out.println("Thank you!");
                break;
            }

            if(ch == 1) {
                System.out.print("Enter Amount to Withdraw: ");
                double withdrawAmt = sc.nextDouble();
                atm.withdraw(withdrawAmt);
            } 
            else if(ch == 2) {
                atm.checkBalance();
            } 
            else{
                System.out.print("Enter Amount to Add: ");
                double addAmt = sc.nextDouble();
                atm.addAmount(addAmt);
            } 
           
        }


    }
}
