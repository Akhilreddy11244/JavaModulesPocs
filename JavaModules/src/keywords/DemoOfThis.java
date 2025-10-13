package keywords;

import java.util.*;
class AccLogin {
    int pincode;
    String mailid;

    AccLogin(String mailid, int pincode) {
        this.mailid = mailid;
        this.pincode = pincode;
    }
    void verifyLogin() {
        if (this.pincode != 0) {
        	this.displayLoginDetails(); 
            System.out.println("Thanks for logging");
        } else {
            System.out.println("Error....");
        }
    }
    void displayLoginDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Mail ID: " + this.mailid);
        System.out.println("Pincode: " + this.pincode);
    }

}
public class DemoOfThis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Login Details:");
        System.out.print("Enter Mail: ");
        String mail = sc.nextLine();
        System.out.print("Enter Password (as pincode): ");
        int pin = sc.nextInt();
        AccLogin acc = new AccLogin(mail, pin);
        acc.verifyLogin();
    }
}
