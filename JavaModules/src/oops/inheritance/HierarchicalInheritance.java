package oops.inheritance;

import java.util.*;
class PersonInfo {
    String name;
    int age;
    String gender;

    PersonInfo(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
class Students extends PersonInfo {
    int studentId;
    String course;

    Students(String name, int age, String gender, int studentId, String course) {
        super(name, age, gender);
        this.studentId = studentId;
        this.course = course;
    }

    void display() {
        System.out.println("\nStudent Details ");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class Faculty extends PersonInfo {
    int empId;
    String subject;

    Faculty(String name, int age, String gender, int empId, String subject) {
        super(name, age, gender);
        this.empId = empId;
        this.subject = subject;
    }

    void display() {
        System.out.println("\nFaculty Details ");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Employee ID: " + empId);
        System.out.println("Subject: " + subject);
    }
}

public class HierarchicalInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Option:");
        System.out.println("1. Enter Student Details");
        System.out.println("2. Enter Faculty Details");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("\nEnter Student Details:");
            System.out.print("Name: ");
            String sname = sc.nextLine();

            System.out.print("Age: ");
            int sage = sc.nextInt();
            sc.nextLine();

            System.out.print("Gender: ");
            String sgender = sc.nextLine();

            System.out.print("Student ID: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();
            Students student = new Students(sname, sage, sgender, sid, course);
            student.display();

        } else if (choice == 2) {
            System.out.println("\nEnter Faculty Details:");
            System.out.print("Name: ");
            String tname = sc.nextLine();

            System.out.print("Age: ");
            int tage = sc.nextInt();
            sc.nextLine();

            System.out.print("Gender: ");
            String tgender = sc.nextLine();

            System.out.print("Employee ID: ");
            int tid = sc.nextInt();
            sc.nextLine();

            System.out.print("Subject: ");
            String subject = sc.nextLine();

            Faculty teacher = new Faculty(tname, tage, tgender, tid, subject);
            teacher.display();
        } 
        else {
            System.out.println("Invalid Option! Please select 1 or 2.");
        }

        sc.close();
    }
}
