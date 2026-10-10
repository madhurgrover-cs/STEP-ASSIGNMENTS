// A1_BankingApplication.java
public class A1_BankingApplication {
    public static void main(String[] args) {
        System.out.println("=== Banking Application Concurrent Tasks (Runnable) ===");

        Thread txThread = new Thread(new BankingTask("Transaction Processing", 150));
        Thread balanceThread = new Thread(new BankingTask("Balance Updating", 200));
        Thread smsThread = new Thread(new BankingTask("SMS Notification", 250));

        txThread.setName("TxProc-Thread");
        balanceThread.setName("BalanceUpdate-Thread");
        smsThread.setName("SMSNotify-Thread");

        txThread.start();
        balanceThread.start();
        smsThread.start();

        try {
            txThread.join();
            balanceThread.join();
            smsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All banking concurrent tasks executed successfully.");
    }
}

class BankingTask implements Runnable {
    private String activityName;
    private long sleepDelay;

    public BankingTask(String activityName, long sleepDelay) {
        this.activityName = activityName;
        this.sleepDelay = sleepDelay;
    }

    @Override
    public void run() {
        try {
            for (int count = 1; count <= 3; count++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + 
                                   " | Activity: " + activityName + 
                                   " | Execution Count: " + count);
                Thread.sleep(sleepDelay);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
