package collectionframeworks;
import java.util.*;

public class BrowserNavigationPOC {

    public static void main(String[] args) {
        LinkedList<String> history = new LinkedList<>();
        ListIterator<String> iterator = history.listIterator();

        Scanner sc = new Scanner(System.in);
        String command;

        System.out.println("Browser Navigation Simulation");
        System.out.println("Commands: visit <url> | back | forward | exit");

        while (true) {
            System.out.print("\nEnter command: ");
            command = sc.nextLine();

            if (command.startsWith("visit ")) {
                String url = command.substring(6);

                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }

                iterator.add(url);
                System.out.println("Visited: " + url);
            } 
            else if (command.equals("back")) {
                if (iterator.hasPrevious()) {
                    String current = iterator.previous();
                    System.out.println("Moved Back to: " + current);
                } else {
                    System.out.println("No previous page!");
                }
            } 
            else if (command.equals("forward")) {
                if (iterator.hasNext()) {
                    String current = iterator.next();
                    System.out.println("Moved Forward to: " + current);
                } else {
                    System.out.println("No forward page!");
                }
            } 
            else if (command.equals("exit")) {
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }

        sc.close();
    }
}
