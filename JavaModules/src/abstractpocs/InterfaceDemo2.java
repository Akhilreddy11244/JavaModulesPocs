package abstractpocs;
import java.util.*;

interface Player {
    void displayStats();
}

class Batsman implements Player {
    String name;
    int runs;

    Batsman(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    public void displayStats() {
        System.out.println("Batsman: " + name + ", Runs: " + runs);
    }
}

class Bowler implements Player {
    String name;
    int wickets;

    Bowler(String name, int wickets) {
        this.name = name;
        this.wickets = wickets;
    }

    public void displayStats() {
        System.out.println("Bowler: " + name + ", Wickets: " + wickets);
    }
}

public class InterfaceDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Type (1-Batsman, 2-Bowler): ");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        Player p;
        if(type == 1) {
            System.out.print("Enter Runs Scored: ");
            int runs = sc.nextInt();
            p = new Batsman(name, runs);
        } else {
            System.out.print("Enter Wickets Taken: ");
            int wickets = sc.nextInt();
            p = new Bowler(name, wickets);
        }

        System.out.println("\nPlayer Stats");
        p.displayStats();
    }
}
