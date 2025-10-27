package threadspocs;

class Book {
    static int total = 10;

    synchronized public void booked(int seat) {
        if (total >= seat) {
            total -= seat;
            System.out.println("Booked: "+seat);
            System.out.println("Seats left: " + total);
        } else {
            System.out.println(" can't book " + seat + " seats. Only " + total + " left.");
        }
    }
}

class CreateThread implements Runnable {
    Book b;
    int seat;

    CreateThread(Book b, int seat) {
        this.b = b;
        this.seat = seat;
    }

    @Override
    public void run() {
        b.booked(seat);
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        Book b = new Book();

        Thread t1 = new Thread(new CreateThread(b, 7));
        Thread t2 = new Thread(new CreateThread(b, 5));

        t1.start();
        t2.start();
    }
}
