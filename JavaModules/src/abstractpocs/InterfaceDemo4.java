package abstractpocs;
//Metro
import java.util.*;

interface Ticket {
    void bookTicket();
    void displayTicket();
}

class RegularTicket implements Ticket {
    String passengerName;
    String fromStation;
    String toStation;
    double fare;

    RegularTicket(String passengerName, String fromStation, String toStation, double fare) {
        this.passengerName = passengerName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.fare = fare;
    }

    public void bookTicket() {
        System.out.println("\nBooking Regular Ticket");
    }

    public void displayTicket() {
        System.out.println("\nRegular Ticket ");
        System.out.println("Passenger: " + passengerName);
        System.out.println("From: " + fromStation);
        System.out.println("To: " + toStation);
        System.out.println("Fare: " + fare);
    }
}

class PremiumTicket implements Ticket {
    String passengerName;
    String fromStation;
    String toStation;
    double fare;

    PremiumTicket(String passengerName, String fromStation, String toStation, double fare) {
        this.passengerName = passengerName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.fare = fare;
    }

    public void bookTicket() {
        System.out.println("\nBooking Premium Ticket");
    }

    public void displayTicket() {
        System.out.println("\nPremium Ticket");
        System.out.println("Passenger: " + passengerName);
        System.out.println("From: " + fromStation);
        System.out.println("To: " + toStation);
        System.out.println("Fare: " + fare);
    }
}

public class InterfaceDemo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter From Station: ");
        String from = sc.nextLine();
        System.out.print("Enter To Station: ");
        String to = sc.nextLine();
        System.out.print("Enter Ticket Type (1-Regular, 2-Premium): ");
        int type = sc.nextInt();

        Ticket t;
        double fare = 50;

       
          if(type == 2) fare += 30; 
        

        if(type == 1) {
            t = new RegularTicket(name, from, to, fare);
        } else {
            t = new PremiumTicket(name, from, to, fare);
        }

        t.bookTicket();
        t.displayTicket();
        sc.close();
    }
}

