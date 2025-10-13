package abstractc;
import java.util.*;

abstract class Payment {
    String studentName;
    String studentId;
    void getStudentDetails(String name, String id) {
        studentName = name;
        studentId = id;
        System.out.println("\nStudent Details:- ");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
    }
    abstract void calculateFee();
}
class EngineeringPayment extends Payment {
    void calculateFee() {
        double tuition = 50000;
        double labFee = 10000;
        double scholarship = 5000;
        double total = tuition + labFee - scholarship;
        System.out.println("Category: Engineering");
        System.out.println("Total Fee (after scholarship): " + total);
    }
}
class ManagementPayment extends Payment {
    void calculateFee() {
        double tuition = 60000;
        double labFee = 8000;
        double scholarship = 5000;
        double total = tuition + labFee - scholarship;
        System.out.println("Category: Management");
        System.out.println("Total Fee: " + total);
    }
}
public class FeePayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.println("Choose number based on deparment (1.Engineering 2.Management): ");
        int choice = sc.nextInt();
        Payment p; 
        if(choice==1)
        {
        	p = new EngineeringPayment();
        }
        else
        {
        	p = new ManagementPayment();
        }

        p.getStudentDetails(name, id);
        p.calculateFee();

        sc.close();
    }
}

