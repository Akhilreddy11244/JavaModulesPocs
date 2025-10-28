package exceptionhandling;
import java.util.*;

class FailException extends Exception {
    FailException() {
        super("Failed to Generate Certificate");
    }

    FailException(String message) {
        super(message);
    }
}
class Student {
    String name;
    int rollNo;
    int[] marks = new int[5];
    String[] subjects = {"JAVA", "CPP", "Python", "DBMS", "Labs"};
    String[] grades = new String[5];
    double sgpa;

    void enterMarks(Scanner sc) {
        System.out.println("\nEnter marks for " + name + " (out of 100):");
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i] + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine();
    }
    void calculateGrades() {
        double totalPoints = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 90) grades[i] = "O";
            else if (marks[i] >= 80) grades[i] = "A+";
            else if (marks[i] >= 70) grades[i] = "A";
            else if (marks[i] >= 60) grades[i] = "B";
            else if (marks[i] >= 50) grades[i] = "C";
            else grades[i] = "F";

            totalPoints += getGradePoint(grades[i]);
        }
        sgpa = totalPoints / marks.length;
    }

    double getGradePoint(String grade) {
        switch (grade) {
            case "O": return 10;
            case "A+": return 9;
            case "A": return 8;
            case "B": return 7;
            case "C": return 6;
            default: return 0;
        }
    }
    void validateResult() throws FailException {
        for (String g : grades) {
            if (g.equals("F")) {
                throw new FailException("Result: Fail! Cannot download certificate.");
            }
        }
    }
    void displayCertificate() {
        System.out.println("\n-----------------------------------------");
        System.out.println("         COLLEGE SEMESTER RESULT         ");
        System.out.println("-----------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("-----------------------------------------");
        System.out.println("Subject\t\tMarks\tGrade\tPoints");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s\t%d\t%s\t%.1f\n", subjects[i], marks[i], grades[i], getGradePoint(grades[i]));
        }
        System.out.println("-----------------------------------------");
        System.out.printf("SGPA: %.2f / 10.00\n", sgpa);
        System.out.println("Status: PASS");
        System.out.println("Certificate Generated Successfully!\n");
    }
    void displayFailedSubjects() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Name: " + name + " | Roll No: " + rollNo);
        System.out.println("Result: FAIL");
        System.out.println("Failed Subjects:");
        for (int i = 0; i < subjects.length; i++) {
            if (grades[i].equals("F")) {
                System.out.println("- " + subjects[i]);
            }
        }
        System.out.println("Please reappear for these subjects.\n");
    }
}

public class CollegePortal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];
        System.out.println("\nFACULTY INPUT SECTION:");
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            System.out.print("\nEnter Student Name: ");
            students[i].name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            students[i].rollNo = sc.nextInt();
            sc.nextLine();
            students[i].enterMarks(sc);
            students[i].calculateGrades();
        }
        System.out.println("\n--- STUDENT DOWNLOAD SECTION ---");
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter your Name: ");
            String nameInput = sc.nextLine();
            System.out.print("Enter your Roll Number: ");
            int rollInput = sc.nextInt();
            sc.nextLine();

            for (Student s : students) {
                if (s.name.equalsIgnoreCase(nameInput) && s.rollNo == rollInput) {
                    System.out.print("Do you want to download certificate? (yes/no): ");
                    String choice = sc.nextLine();

                    if (choice.equalsIgnoreCase("yes")) {
                        try {
                            s.validateResult();
                            s.displayCertificate();
                        } catch (FailException e) {
                            System.out.println(e.getMessage());
                            s.displayFailedSubjects();
                        }
                    } else {
                        System.out.println("Certificate download skipped.\n");
                    }
                }
            }
        }
        sc.close();
    }
}
