package collectionframeworks;
import java.util.*;
class Product {
    String name;
    String category;
    double price;
    double rating;
    Product(String name, String category, double price, double rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }
    @Override
    public String toString() {
        return name + " | " + category + " | " + price + " | " + rating;
    }
}
public class ProductArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
            new Product("Laptop", "Electronics", 55000, 4.3),
            new Product("Shoes", "Fashion", 2500, 4.1),
            new Product("Mobile", "Electronics", 20000, 4.7),
            new Product("Watch", "Accessories", 3000, 3.9),
            new Product("Headphones", "Electronics", 1500, 4.5)
        };

        while (true) {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. View all products");
            System.out.println("2. Sort by Price");
            System.out.println("3. Sort by Rating");
            System.out.println("4. Sort by Name");
            System.out.println("5. Filter by Category");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    display(products);
                    break;
                case 2:
                    Arrays.sort(products, Comparator.comparingDouble(p -> p.price));
                    System.out.println("\nSorted by Price:");
                    display(products);
                    break;

                case 3:
                    Arrays.sort(products, (a, b) -> Double.compare(b.rating, a.rating));
                    System.out.println("\nSorted by Rating:");
                    display(products);
                    break;

                case 4:
                    Arrays.sort(products, Comparator.comparing(p -> p.name));
                    System.out.println("\nSorted by Name:");
                    display(products);
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    System.out.println("\nProducts in " + cat + " category:");
                    for (Product p : products)
                        if (p.category.equalsIgnoreCase(cat))
                            System.out.println(p);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void display(Product[] products) {
        for (Product p : products)
            System.out.println(p);
    }
}
