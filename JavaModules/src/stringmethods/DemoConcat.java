package stringmethods;
import java.util.*;

public class DemoConcat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ID Card Form");

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Middle Name: ");
        String middleName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter D.O.B (Month Date, Year): ");
        String dob = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        String fullName = String.join(" ", firstName, middleName, lastName);

        System.out.println("\nStudent ID Card ");
        System.out.println("Full Name : " + fullName);
        System.out.println("D.O.B : " + dob);
        System.out.println("Department: " + department);

        System.out.println("\nSelect Option:");
        System.out.println("1. Error in Data");
        System.out.println("2. Exit");
        int option = sc.nextInt();
        sc.nextLine(); 

        if (option == 1) {
            System.out.println("\nEnter option to replace data:");
            System.out.println("1. First Name");
            System.out.println("2. Middle Name");
            System.out.println("3. Last Name");
            System.out.println("4. D.O.B");
            System.out.println("5. Department");
            int errorOption = sc.nextInt();
            sc.nextLine(); 

            switch (errorOption) {
                case 1:
                    System.out.print("Enter new First Name: ");
                    String newFirstName = sc.nextLine();
                    firstName = firstName.replace(firstName, newFirstName);
                    break;
                case 2:
                    System.out.print("Enter new Middle Name: ");
                    middleName = sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new Last Name: ");
                    lastName = sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter new D.O.B (Month Date, Year): ");
                    dob = sc.nextLine();
                    break;
                case 5:
                    System.out.print("Enter new Department: ");
                    department = sc.nextLine();
                    break;
                default:
                    System.out.println("Invalid option!");
            }


            fullName = String.join(" ", firstName, middleName, lastName);

            System.out.println("\nUpdated Student ID Card");
            System.out.println("Full Name : " + fullName);
            System.out.println("D.O.B : " + dob);
            System.out.println("Department: " + department);
        } 
        else {
            System.out.println("Thank you! Exiting...");
        }

        sc.close();
    }
}
