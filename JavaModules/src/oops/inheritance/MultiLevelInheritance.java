package oops.inheritance;

import java.util.*;
class PersonInformation {
	String name, gender;
	int age;

	PersonInformation(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
}
class Employee extends PersonInformation {
	int empid;
	String department;

	Employee(String name, String gender, int age, int empid, String department) {
		super(name, gender, age);
		this.empid = empid;
		this.department = department;
	}
}
class Teacher extends Employee {
	String subject;

	Teacher(String name, String gender, int age, int empid, String department, String subject) {
		super(name, gender, age, empid, department);
		this.subject = subject;
	}

	void display() {
		System.out.println("\nTeacher Details:");
		System.out.println("Name: " + name);
		System.out.println("Gender: " + gender);
		System.out.println("Age: " + age);
		System.out.println("Employee ID: " + empid);
		System.out.println("Department: " + department);
		System.out.println("Subject: " + subject);
	}
}
public class MultiLevelInheritance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Gender: ");
		String gender = sc.nextLine();

		System.out.print("Enter Age: ");
		int age = sc.nextInt();

		System.out.print("Enter Employee ID: ");
		int empid = sc.nextInt();
		sc.nextLine(); 

		System.out.print("Enter Department: ");
		String department = sc.nextLine();

		System.out.print("Enter Subject: ");
		String subject = sc.nextLine();

		Teacher obj = new Teacher(name, gender, age, empid, department, subject);
		obj.display();

		sc.close();
	}
}
