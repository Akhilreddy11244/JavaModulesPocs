package oops.polymorphism;
import java.util.*;

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Overridden method
    void showRole() {
        System.out.println("I am a person in the college.");
    }
}

class Student extends Person {
    String department;

    Student(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    @Override
    void showRole() {
        System.out.println("I am a student from the " + department + " department.");
    }
}


class TeachingStaff extends Person {
    String subject;

    TeachingStaff(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    @Override
    void showRole() {
        System.out.println("I am a teaching staff member. I teach " + subject + ".");
    }
}

class NonTeachingStaff extends Person {
    String role;

    NonTeachingStaff(String name, int id, String role) {
        super(name, id);
        this.role = role;
    }

    @Override
    void showRole() {
        System.out.println("I am a non-teaching staff member. My role is " + role + ".");
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person> people = new ArrayList<>();//I can store the date to print

        System.out.print("Enter number of people to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Person " + (i) + ":");
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Type (Student / Teaching / NonTeaching): ");
            String type = sc.nextLine();

            Person p; 
            if (type.equals("Student")) {
                System.out.print("Enter Department: ");
                String dept = sc.nextLine();
                p = new Student(name, id, dept);

            } else if (type.equals("Teaching")) {
                System.out.print("Enter Subject: ");
                String subject = sc.nextLine();
                p = new TeachingStaff(name, id, subject);

            } else {
                System.out.print("Enter Role: ");
                String role = sc.nextLine();
                p = new NonTeachingStaff(name, id, role);
            }
            people.add(p);
        }

        System.out.println("\nCollege Members and Their Roles");
        for (Person person : people) {
            System.out.println("\nName: " + person.name + "\nId: " + person.id);
            person.showRole(); 
        }
    }
}
