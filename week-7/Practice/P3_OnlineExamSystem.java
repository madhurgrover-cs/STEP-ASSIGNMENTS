// P3_OnlineExamSystem.java
public class P3_OnlineExamSystem {
    public static void main(String[] args) {
        System.out.println("=== Online Examination System (Runnable Interface) ===");

        Thread timeThread = new Thread(new RemainingTimeTask());
        Thread saveThread = new Thread(new AutoSaveTask());
        Thread networkThread = new Thread(new NetworkCheckTask());

        timeThread.setName("TimeDisplayThread");
        saveThread.setName("AutoSaveThread");
        networkThread.setName("NetworkCheckThread");

        timeThread.start();
        saveThread.start();
        networkThread.start();

        try {
            timeThread.join();
            saveThread.join();
            networkThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Online Examination activities completed successfully.");
    }
}

class RemainingTimeTask implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[" + Thread.currentThread().getName() + "] Activity: Displaying Remaining Time (" + (180 - i * 15) + " mins left)");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}

class AutoSaveTask implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[" + Thread.currentThread().getName() + "] Activity: Auto-saving student answers...");
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}

class NetworkCheckTask implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[" + Thread.currentThread().getName() + "] Activity: Checking network connection status...");
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
    }
}
