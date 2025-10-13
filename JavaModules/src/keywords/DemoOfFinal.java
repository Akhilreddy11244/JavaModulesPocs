package keywords;
import java.util.*;
class PlacementsRules {
    final String COLLEGE_NAME = "CMR"; 
// Final-keyword
    final void displayRules() { 
        System.out.println("\nPlacements Rules");
        System.out.println("1. Attendance minimum 75%.");
        System.out.println("2. No Active Backlogs.");
    }
}
final class Student extends PlacementsRules {  
    String name;
    int rollNo;
    String branch;

    Student(String name, int rollNo, String branch) {
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
    }
    void displayStudentDetails() {
        System.out.println("\nStudent Details");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Branch: " + branch);
        System.out.println("College: " + COLLEGE_NAME);
    }
}
public class DemoOfFinal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Details:");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        Student s = new Student(name, rollNo, branch);

        s.displayStudentDetails();
        s.displayRules();
    }
}
