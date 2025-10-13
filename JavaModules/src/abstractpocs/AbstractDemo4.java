package abstractpocs;
import java.util.*;

abstract class Ride {
    String src, dest;
    double distance;

    Ride(String src, String dest, double distance) {
        this.src = src;
        this.dest = dest;
        this.distance = distance;
    }

    abstract double calculate();
}

class OlaRide extends Ride {
    OlaRide(String source, String destination, double distance) {
        super(source, destination, distance);
    }

    double calculate() {
        return distance * 10; 
    }
}

public class AbstractDemo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Pickup: ");
        String from = sc.nextLine();
        System.out.print("Enter Drop: ");
        String to = sc.nextLine();
        System.out.print("Enter Distance (km): ");
        double km = sc.nextDouble();

        Ride r = new OlaRide(from, to, km);
        System.out.println("\nRide Fare: " + r.calculate());
    }
}
