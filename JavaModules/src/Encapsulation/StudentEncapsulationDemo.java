package Encapsulation;
import java.util.*;
class Student {
    private String name;
    private int rollNo,marks;
    private String department;
  
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
      
        if (marks >= 0 && marks <= 100)
            this.marks = marks;
        else
            System.out.println("Invalid marks! Please enter between 0–100.");
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void displayStudentInfo() {
        System.out.println("\nUpdated Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
        System.out.println("Marks: " + marks);
    }
}

public class StudentEncapsulationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        System.out.print("Enter Student Name: ");
        s.setName(sc.nextLine());

        System.out.print("Enter Roll Number: ");
        s.setRollNo(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Department: ");
        s.setDepartment(sc.nextLine());

        System.out.print("Enter Marks(Round Off): ");
        s.setMarks(sc.nextInt());

        s.displayStudentInfo();
        sc.close();
    }
}
