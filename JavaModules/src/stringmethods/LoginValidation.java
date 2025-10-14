package stringmethods;
import java.util.*;
//isEmpty(), length(),toLowerCase(),.equals
public class LoginValidation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("USER REGISTRATION FORM");

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Email ID: ");
        String email = sc.nextLine().trim();
        email = email.toLowerCase();

        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        System.out.print("Re-enter Password: ");
        String rePassword = sc.nextLine().trim();

        boolean isValid = true;

        if (name.isEmpty()) {
            System.out.println("Name field cannot be empty.");
            isValid = false;
        }

        if (email.isEmpty() || !email.contains("@gmail.com")) {
            System.out.println("Please enter a valid email address.");
            isValid = false;
        }

        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            isValid = false;
        } else if (password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            isValid = false;
        }

        if (!password.equals(rePassword)) {
            System.out.println("Passwords do not match.");
            isValid = false;
        }

        if (isValid) {
            System.out.println("\nRegistration Successful!");
            System.out.println("Welcome, " + name);
            System.out.println("Registered Email: " + email);
        } else {
            System.out.println("\nRegistration Failed. Please correct the above errors and try again.");
        }
    }
}
