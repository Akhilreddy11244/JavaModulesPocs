package threadspocs;

class FileDownloader implements Runnable {
    private String fileName;
    private int downloadTime;

    public FileDownloader(String fileName, int downloadTime) {
        this.fileName = fileName;  // Corrected
        this.downloadTime = downloadTime;
    }

    public void run() {
        System.out.println("Starting download: " + fileName);
        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep(downloadTime);
            } catch (InterruptedException e) {
                System.out.println(fileName + " interrupted.");
            }
            System.out.println(fileName + " downloaded " + (i * 25) + "%");
        }
        System.out.println(fileName + " download complete!");
    }
}

public class ThreadPoc {
    public static void main(String[] args) throws InterruptedException {
        Thread file1 = new Thread(new FileDownloader("File_A.zip", 500));
        file1.start();
        file1.join();

        Thread file2 = new Thread(new FileDownloader("File_B.mp4", 700));
        file2.start();
        file2.join();

        Thread file3 = new Thread(new FileDownloader("File_C.pdf", 600));
        file3.start();
    }
}
