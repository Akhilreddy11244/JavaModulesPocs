package keywords;

import java.util.Scanner;

class AccLogin {
    int pincode;
    String mailid;
    String captcha;

    AccLogin(String mailid, int pincode) {
        this.mailid = mailid;
        this.pincode = pincode;
    }

    AccLogin(String mailid, int pincode, String captcha) {
        this(mailid, pincode); 
        this.captcha = captcha;
    }

    void verifyLogin() {
        if (this.pincode != 0) {
            this.displayLoginDetails();
            System.out.println("Thanks for logging in!");
        } else {
            System.out.println("Error: Invalid pincode.");
        }
    }

    void displayLoginDetails() {
        System.out.println("\nAccount Details ");
        System.out.println("Mail ID: " + this.mailid);
        System.out.println("Pincode: " + this.pincode);
        if (this.captcha != null && !this.captcha.isEmpty()) {
            System.out.println("Captcha: " + this.captcha);
        }
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

       
        sc.nextLine();

        System.out.print("Enter captcha (or press Enter to skip): ");
        String captcha = sc.nextLine();

        if (!captcha.isEmpty()) {
            AccLogin acc = new AccLogin(mail, pin, captcha);
            acc.verifyLogin();
        } else {
            AccLogin acc = new AccLogin(mail, pin);
            acc.verifyLogin();
        }
        
        sc.close();
    }
}