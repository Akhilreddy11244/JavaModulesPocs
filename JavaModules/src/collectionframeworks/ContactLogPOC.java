package collectionframeworks;
import java.util.*;

public class ContactLogPOC {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String command;

        System.out.println("Contact Log System");
        System.out.println("Commands: add | search | update | delete | show | exit");
        while (true) {
            System.out.print("\nEnter command: ");
            command = sc.nextLine().toLowerCase();
            switch (command) {
                case "add":
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String number = sc.nextLine();

                    if (contacts.containsKey(name)) {
                        System.out.println("Contact already exists! Try 'update' instead.");
                    } else {
                        contacts.put(name, number);
                        System.out.println("Added: " + name + " -> " + number);
                    }
                    break;

                case "search":
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    if (contacts.containsKey(searchName)) {
                        System.out.println(searchName + " : " + contacts.get(searchName));
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;

                case "update":
                    System.out.print("Enter name to update: ");
                    String updateName = sc.nextLine();
                    if (contacts.containsKey(updateName)) {
                        System.out.print("Enter new number: ");
                        String newNumber = sc.nextLine();
                        contacts.put(updateName, newNumber);
                        System.out.println("Updated successfully!");
                    } else {
                        System.out.println("No contact found with that name!");
                    }
                    break;

                case "delete":
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    if (contacts.remove(deleteName) != null) {
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("No contact found!");
                    }
                    break;

                case "show":
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts saved!");
                    } else {
                        System.out.println("\nContact List:");
                        for (Map.Entry<String, String> entry : contacts.entrySet()) {
                            System.out.println(entry.getKey() + " : " + entry.getValue());
                        }
                    }
                    break;

                case "exit":
                    System.out.println("Exiting Contact Log...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}

