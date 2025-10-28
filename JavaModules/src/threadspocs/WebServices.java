package threadspocs;

class Server {
    private int totalRequestsProcessed = 0;
    private int completedRequests = 0;
    private int activeRequests = 0;

    public synchronized void processRequest(String requestType, int requestId) {
        totalRequestsProcessed++;
        activeRequests++;

        System.out.println("[Thread-" + Thread.currentThread().getId() + "] Started Request " 
                           + requestId + " (" + requestType + "). Active: " + activeRequests);

        try {
            switch (requestType) {
                case "GET": Thread.sleep(500); break;
                case "POST": Thread.sleep(1000); break;
                case "PUT": Thread.sleep(800); break;
                case "DELETE": Thread.sleep(700); break;
                case "UPDATE": Thread.sleep(600); break;
            }
            System.out.println("[Thread-" + Thread.currentThread().getId() + "] Request " 
                               + requestId + " (" + requestType + ") updated DB successfully.");
        } catch (InterruptedException e) {
            System.out.println("[Thread-" + Thread.currentThread().getId() + "] Request " 
                               + requestId + " interrupted.");
        }
        activeRequests--;
        completedRequests++;

        System.out.println("[Thread-" + Thread.currentThread().getId() + "] Completed Request " 
                           + requestId + " (" + requestType + "). Completed: " + completedRequests
                           + " | Active: " + activeRequests);
    }
    public int getTotalRequestsProcessed() {
        return totalRequestsProcessed;
    }
    public int getCompletedRequests() {
        return completedRequests;
    }
    public int getActiveRequests() {
        return activeRequests;
    }
}

class Request implements Runnable {
    private int requestId;
    private String requestType;
    private Server server;

    public Request(int requestId, String requestType, Server server) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("[Thread-" + Thread.currentThread().getId() + "] Request " 
                           + requestId + " (" + requestType + ") received by server.\n");
        server.processRequest(requestType, requestId);
    }
}

class ServerMonitor implements Runnable {
    private Server server;

    public ServerMonitor(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while (true) { 
                System.out.println("[Monitor] Active Requests: " + server.getActiveRequests()
                                   + " | Completed Requests: " + server.getCompletedRequests()
                                   + " | Total Requests Started: " + server.getTotalRequestsProcessed());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("[Monitor] Interrupted.");
        }
    }
}

public class WebServices {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        String[] requestTypes = {"GET", "POST", "PUT", "DELETE", "UPDATE"};

        Thread monitor = new Thread(new ServerMonitor(server));
        monitor.setDaemon(true);
        monitor.start();
        Thread[] threads = new Thread[6];

        for (int i = 0; i < 6; i++) {
            String type = requestTypes[i % requestTypes.length]; 
            threads[i] = new Thread(new Request(i + 1, type, server));

            if (type.equals("POST") || type.equals("DELETE")) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.NORM_PRIORITY);
            }

            threads[i].start();
            System.out.println();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All requests processed. Total: " + server.getTotalRequestsProcessed());
    }
}
