package oops.inheritance;
class Persons {
	 String name;
	 int age;
	
	 Persons(String name, int age) {
	     this.name = name;
	     this.age = age;
	 }
	
	 void showPersonInfo() {
	     System.out.println("Name: " + name + ", Age: " + age);
	 }
}

class Student extends Persons {
	 int rollNo;
	 String course;
	
	 Student(String name, int age, int rollNo, String course) {
	     super(name, age);
	     this.rollNo = rollNo;
	     this.course = course;
	 }
	
	 void displayStudentInfo() {
	     super.showPersonInfo();
	     System.out.println("Roll No: " + rollNo + ", Course: " + course);
	 }
}

class Professor extends Persons {
	 int empId;
	 String subject;
	
	 Professor(String name, int age, int empId, String subject) {
	     super(name, age);
	     this.empId = empId;
	     this.subject = subject;
	 }
	
	 void displayProfessorInfo() {
	     showPersonInfo();
	     System.out.println("Employee ID: " + empId + ", Subject: " + subject);
	 }
}

class TeachingAssistant extends Student {
	 String assignedSubject;
	
	 TeachingAssistant(String name, int age, int rollNo, String course, String assignedSubject) {
	     super(name, age, rollNo, course);
	     this.assignedSubject = assignedSubject;
	 }
	
	 void displayTAInfo() {
	     displayStudentInfo();
	     System.out.println("Assigned Subject: " + assignedSubject);
	 }
}

public class HybridInheritance {
 public static void main(String[] args) {
     Student s1 = new Student("Alice", 20, 101, "Computer Science");
     s1.displayStudentInfo();
     System.out.println();

     Professor f1 = new Professor("Dr. Bob", 45, 1001, "Mathematics");
     f1.displayProfessorInfo();
     System.out.println();

     TeachingAssistant ta1 = new TeachingAssistant("Charlie", 22, 102, "Computer Science", "Physics");
     ta1.displayTAInfo();
 }
}
