package stringmethods;

import java.util.Scanner;
//compareTo(),compareToIgnoreCase(),.equal(),.equalIgnoreCase()
public class Comparators {

	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);

	        System.out.println("USER REGISTRATION FORM");

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine().trim();

	        System.out.print("Enter Email ID: ");
	        String email = sc.nextLine().trim();
	        email = email.toLowerCase();

	        System.out.print("Enter Password: ");
	        String password = sc.nextLine().trim();

	        System.out.print("Re-enter Password: ");
	        String rePassword = sc.nextLine().trim();
	        
	        System.out.println("USER LOGIN FORM");
	        
//	        System.out.println("Enter Name: ");
//	        String lname = sc.nextLine();
	        
	        boolean flag = true;
	        System.out.println("Enter Email Id: ");
	        String lmail = sc.nextLine();
	        System.out.println("Enter Passwword");
	        String lpass = sc.nextLine();
//	        if(!email.equalsIgnoreCase(lmail))
//	        {
//	        	System.out.println("Invalid Mail Id");
//	        	flag = false;
//	        }
	        if(email.compareToIgnoreCase(lmail)==0)
	        {
	        	System.out.println("Invalid Mail Id");
	        	flag = false;
	        }
	        if(!password.equals(lpass))
	        {
	        	System.out.println("Invalid Password");
	        	flag = false;
	        }
	        
	        if(flag)
	        {
	        	System.out.println("Welcome");
	        }
	        
	}

}
