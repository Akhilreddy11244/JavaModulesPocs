package threadspocs;

class Check extends Thread {
    int sum = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            try {
            Thread.currentThread().sleep(1000);
            notify();
            Thread.currentThread().sleep(1000);
            }
            catch(Exception e) {
            	
            }
            System.out.println("Sum calculated: " + sum);

            // notify(); 
        }
    }
}

public class WaitPocs {
    public static void main(String[] args) {
        Check c = new Check();
        c.start();

        synchronized (c) {
            try {  
                System.out.println("Main thread waiting...");
                
                c.wait(); 
                System.out.println("Wait done!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final sum: " + c.sum);
    }
}
