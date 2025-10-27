package keywords;

import java.util.Scanner;

class DetailsOfCMR{
	static String collegeName = "CMR";
	String name,branch;
	int stdId;
	DetailsOfCMR(String name,String branch,int stdid)
	{
		this.name = name;
		this.branch = branch;
		this.stdId = stdid;
	}
	void display()
	{
		System.out.println("Deatils:- ");
		System.out.println("Name: "+name);
		System.out.println("Branch: "+branch);
		System.out.println("Student ID: "+stdId);
		System.out.println("college Name: "+collegeName);
	}
}
public class DemoOfStatic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Below Details");
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Branch: ");
		String branch = sc.nextLine();
		System.out.println("Enter Id: ");
		int stdid = sc.nextInt();
		
		DetailsOfCMR newreg = new DetailsOfCMR(name,branch,stdid);
		newreg.display();
	}
}
