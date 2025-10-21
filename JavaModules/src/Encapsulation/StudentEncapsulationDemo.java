package Encapsulation;
import java.util.*;

class Student {
    private String name;
    private int rollNo, marks;
    private String department;

    protected String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }

    protected int getRollNo() {
        return rollNo;
    }
    protected void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    protected int getMarks() {
        return marks;
    }
    protected void setMarks(int marks) {
        if (marks >= 0 && marks <= 100)
            this.marks = marks;
        else
            System.out.println("Invalid marks! Please enter between 0–100.");
    }

    protected String getDepartment() {
        return department;
    }
    protected void setDepartment(String department) {
        this.department = department;
    }

    protected void displayStudentInfo() {
        System.out.println("\nUpdated Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
        System.out.println("Marks: " + marks);
    }
}
//class Sample extends Student {
//	public void runDisplay() {
//        Student obj = new Student();
//        obj.displayStudentInfo();
//    }
//}
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
