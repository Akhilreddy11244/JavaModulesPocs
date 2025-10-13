package oops.polymorphism;
import java.util.*;

class StudentInfo {
    String name, sgender, scatogory;
    int srollno;

    
    StudentInfo(String name, String sgender, String scatogory, int srollno) {
        this.name = name;
        this.sgender = sgender;
        this.scatogory = scatogory;
        this.srollno = srollno;
    }

    // Constructor Overloading (Compile-time polymorphism)
    StudentInfo(String name, String sgender, int srollno) {
        this.name = name;
        this.sgender = sgender;
        this.srollno = srollno;
        this.scatogory = "General"; 
    }


    void displayInfo() {
        System.out.println("\nStudent Info");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + srollno);
        System.out.println("Gender: " + sgender);
        System.out.println("Category: " + scatogory);
    }
}

public class CompileTimePolymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollno = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Category (General/Lateral Entry): ");
        String category = sc.nextLine();

        if (category.equals("Lateral")) {
        	StudentInfo newstd = new StudentInfo(name, gender, category, rollno);
        	newstd.displayInfo(); 
        } else {
        	StudentInfo newstd = new StudentInfo(name, gender, rollno);
        	newstd.displayInfo(); 
        }
    }
}
