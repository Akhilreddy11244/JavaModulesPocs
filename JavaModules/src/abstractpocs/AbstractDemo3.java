package abstractpocs;
import java.util.*;

abstract class FoodOrder {
    String restaurantName;
    String dish;
    int price;

    FoodOrder(String restaurantName, String dish, int price) {
        this.restaurantName = restaurantName;
        this.dish = dish;
        this.price = price;
    }

    abstract double calculateBill();
}

class SwiggyOrder extends FoodOrder {
    SwiggyOrder(String restaurantName, String dish, int price) {
        super(restaurantName, dish, price);
    }

    double calculateBill() {
        double tax = price * 0.5;
        double delivery = 40;
        return price + tax + delivery;
    }
}

public class AbstractDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Restaurant Name: ");
        String r = sc.nextLine();
        System.out.print("Enter Dish Name: ");
        String dname = sc.nextLine();
        System.out.print("Enter Base Price: ");
        int b = sc.nextInt();

        FoodOrder order = new SwiggyOrder(r, dname, b);
        System.out.println("\nTotal Bill: " + order.calculateBill());
    }
}
