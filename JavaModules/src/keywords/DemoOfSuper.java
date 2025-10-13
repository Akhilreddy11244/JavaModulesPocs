package keywords;
import java.util.*;
class CollegeStaff {
    String name;
    int staffId;
    String department;

    CollegeStaff(String name, int staffId, String department) {
        this.name = name;
        this.staffId = staffId;
        this.department = department;
    }
    void displayDetails() {
        System.out.println("\nCollege Staff Details");
        System.out.println("Staff Name: " + name);
        System.out.println("Staff ID: " + staffId);
        System.out.println("Department: " + department);
    }
}
class TeachingStaff extends CollegeStaff {
    String subject;
    double salary;
    TeachingStaff(String name, int staffId, String department, String subject, double salary) {
        super(name, staffId, department); 
        this.subject = subject;
        this.salary = salary;
    }
    void displayDetails() {
        super.displayDetails(); 
        System.out.println("Subject: " + subject);
        System.out.println("Salary: " + salary);
    }
}
public class DemoOfSuper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Teaching Staff Details:");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Staff ID: ");
        int staffId = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        TeachingStaff t = new TeachingStaff(name, staffId, department, subject, salary);
        t.displayDetails();
    }
}
