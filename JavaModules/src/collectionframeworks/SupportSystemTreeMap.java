package collectionframeworks;
import java.util.*;


public class SupportSystemTreeMap {

    public static void main(String[] args) {
        TreeMap<String, List<String>> supportTree = new TreeMap<>();

        supportTree.put("Billing Department", Arrays.asList("Refund Team", "Payment Failure Team"));
        supportTree.put("Technical Department", Arrays.asList("App Issues Team", "Website Bugs Team"));
        supportTree.put("Delivery Department", Arrays.asList("Late Delivery Team", "Missing Items Team"));

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Customer Support System ===");
        System.out.println("\nDepartments (Auto-sorted):");
        
        int i = 1;
        for (String dept : supportTree.keySet()) {
            System.out.println(i++ + ". " + dept);
        }

        System.out.print("\nSelect a department number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice >= 1 && choice <= supportTree.size()) {
            String selectedDept = (String) supportTree.keySet().toArray()[choice - 1];
            System.out.println("\n You selected: " + selectedDept);
            System.out.println("Available Teams:");

            List<String> teams = supportTree.get(selectedDept);
            for (int j = 0; j < teams.size(); j++) {
                System.out.println("   " + (j + 1) + ". " + teams.get(j));
            }

            System.out.print("\nSelect a team number to route your ticket: ");
            int teamChoice = sc.nextInt();
            if (teamChoice >= 1 && teamChoice <= teams.size()) {
                System.out.println("Ticket routed to: " + teams.get(teamChoice - 1) + " (" + selectedDept + ")");
            } else {
                System.out.println("Invalid team selection!");
            }
        } else {
            System.out.println("Invalid department selection!");
        }

        sc.close();
    }
}
