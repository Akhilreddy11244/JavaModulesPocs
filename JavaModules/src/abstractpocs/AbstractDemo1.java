
package abstractpocs;
import java.util.*;

abstract class OnlineOrder {
    String customerName;
    String productName;
    double amount;

    OnlineOrder(String customerName, String productName, double amount) {
        this.customerName = customerName;
        this.productName = productName;
        this.amount = amount;
    }

    abstract double calculateDeliveryCharge();
    abstract void displayInvoice();
}

class ExpressDelivery extends OnlineOrder {
    ExpressDelivery(String customerName, String productName, double amount) {
        super(customerName, productName, amount);
    }

    double calculateDeliveryCharge() {
        return 40;
    }

    void displayInvoice() {
        double total = amount + calculateDeliveryCharge();
        System.out.println("\nExpress Delivery Invoice");
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Product Cost: " + amount);
        System.out.println("Delivery Charge: " + calculateDeliveryCharge());
        System.out.println("Total Amount: " + total);
    }
}

public class AbstractDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Product Name: ");
        String product = sc.nextLine();
        System.out.println("Enter Product Cost: ");
        double cost = sc.nextDouble();

        OnlineOrder order = new ExpressDelivery(name, product, cost);
        order.displayInvoice();
    }
}
