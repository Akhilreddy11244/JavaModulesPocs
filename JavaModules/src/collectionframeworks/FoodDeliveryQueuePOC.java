package collectionframeworks;
import java.util.*;

class Order {
    String orderId;
    String source; 
    double tipAmount;

    public Order(String orderId, String source, double tipAmount) {
        this.orderId = orderId;
        this.source = source;
        this.tipAmount = tipAmount;
    }

    @Override
    public String toString() {
        return "[" + orderId + " | " + source + " | ₹" + tipAmount + "]";
    }
}

public class FoodDeliveryQueuePOC {
    public static void main(String[] args) {
       
        PriorityQueue<Order> deliveryQueue = new PriorityQueue<>(
            (o1, o2) -> {
                boolean o1Partner = o1.source.equalsIgnoreCase("zomato") || o1.source.equalsIgnoreCase("swiggy");
                boolean o2Partner = o2.source.equalsIgnoreCase("zomato") || o2.source.equalsIgnoreCase("swiggy");

                if (o1Partner && !o2Partner) return -1;
                if (!o1Partner && o2Partner) return 1;
                return Double.compare(o2.tipAmount, o1.tipAmount);
            }
        );

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nCommands: add | dispatch | view | exit");
            System.out.print("Enter command: ");
            String cmd = sc.nextLine().trim().toLowerCase();

            switch (cmd) {
                case "add":
                    System.out.print("Enter Order ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Source (Zomato/Swiggy/Other): ");
                    String src = sc.nextLine();
                    System.out.print("Enter Tip Amount: ");
                    double tip = sc.nextDouble();
                    sc.nextLine(); 

                    deliveryQueue.offer(new Order(id, src, tip));
                    System.out.println("Order Added to Queue!");
                    break;

                case "dispatch":
                    if (deliveryQueue.isEmpty()) {
                        System.out.println("No orders to dispatch!");
                    } else {
                        System.out.println("Dispatching Order: " + deliveryQueue.poll());
                    }
                    break;

                case "view":
                    if (deliveryQueue.isEmpty()) {
                        System.out.println("No pending orders!");
                    } else {
                        System.out.println("Current Queue (Highest priority first):");
                        deliveryQueue.stream().sorted(
                            (o1, o2) -> {
                                boolean o1Partner = o1.source.equalsIgnoreCase("zomato") || o1.source.equalsIgnoreCase("swiggy");
                                boolean o2Partner = o2.source.equalsIgnoreCase("zomato") || o2.source.equalsIgnoreCase("swiggy");
                                if (o1Partner && !o2Partner) return -1;
                                if (!o1Partner && o2Partner) return 1;
                                return Double.compare(o2.tipAmount, o1.tipAmount);
                            }
                        ).forEach(System.out::println);
                    }
                    break;

                case "exit":
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command!");
            }
        }
    }
}
