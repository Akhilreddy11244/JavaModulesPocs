package oops.inheritance;
import java.util.*;
class Person {
	String name, mail;
	int contact;

	Person(String name, String mail, int contact) {
		this.name = name;
		this.mail = mail;
		this.contact = contact;
	}
}
class Student1 extends Person {
	int stuid;

	Student1(String name, String mail, int contact, int stuid) {
		super(name, mail, contact);
		this.stuid = stuid;
	}
	void display() {
		System.out.println("\nStudent Details");
		System.out.println("Name: " + name);
		System.out.println("Mail: " + mail);
		System.out.println("Contact No: " + contact);
		System.out.println("Student ID: " + stuid);
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Mail ID: ");
		String mail = sc.nextLine();

		System.out.print("Enter Contact Number: ");
		int contact = sc.nextInt();

		System.out.print("Enter Student ID: ");
		int stuid = sc.nextInt();
		Student1 obj = new Student1(name, mail, contact, stuid);
		obj.display();
	}
}

