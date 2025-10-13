package abstractc;

import java.util.*;
interface Subjects {
    void getDepartmentSubjects();
}
interface Labs {
    void getLabRooms();
}
class CSEDepartment implements Subjects, Labs {
    public void getDepartmentSubjects() {
        System.out.println("Subjects offered in CSE Department:");
        System.out.println("1. Java\n2. Python\n3. C++");
    }
    public void getLabRooms() {
        System.out.println("Lab Rooms for CSE Department:");
        System.out.println("1. Java Lab - 101\n2. Python Lab - 102\n3. C++ Lab - 103");
    }
}
class ECEDepartment implements Subjects, Labs {
    public void getDepartmentSubjects() {
        System.out.println("Subjects offered in ECE Department:");
        System.out.println("1. Sensors\n2. Embedded Systems\n3. IoT");
    }
    public void getLabRooms() {
        System.out.println("Lab Rooms for ECE Department:");
        System.out.println("1. Sensors Lab - 201\n2. Embedded Lab - 202\n3. IoT Lab - 203");
    }
}
class MBADepartment implements Subjects, Labs {
    public void getDepartmentSubjects() {
        System.out.println("Subjects offered in MBA Department:");
        System.out.println("1. Business Management\n2. Financial Analysis\n3. Organizational Behavior");
    }
    public void getLabRooms() {
        System.out.println("Lab Rooms for MBA Department:");
        System.out.println("1. Business Simulation Lab - 301\n2. Finance Lab - 302\n3. Communication Lab - 303");
    }
}
public class DepartmentSubjectInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select Department:");
            System.out.println("1. CSE\n2. ECE\n3. MBA\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 4) {
                System.out.println("Thank You");
                break;
            }
            Subjects subjects;
            Labs labs;

            if (choice == 1) {
                subjects = new CSEDepartment();
                labs = (Labs) subjects;  
            } else if (choice == 2) {
                subjects = new ECEDepartment();
                labs = (Labs) subjects;
            } else {
                subjects = new MBADepartment();
                labs = (Labs) subjects;
            }
            System.out.println();
            subjects.getDepartmentSubjects();
            System.out.println();
            labs.getLabRooms();
            System.out.println();
        }

        sc.close();
    }
}
