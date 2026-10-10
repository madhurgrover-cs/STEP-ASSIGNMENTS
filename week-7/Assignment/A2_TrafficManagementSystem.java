// A2_TrafficManagementSystem.java
public class A2_TrafficManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Smart Traffic Management System (Extending Thread) ===");

        JunctionMonitor junction1 = new JunctionMonitor("Heavy Flow (Clearway Required)", 150);
        JunctionMonitor junction2 = new JunctionMonitor("Moderate Flow (Normal Signal Cycle)", 200);
        JunctionMonitor junction3 = new JunctionMonitor("Low Flow (Green Wave Active)", 250);

        junction1.setName("Junction-North");
        junction2.setName("Junction-Central");
        junction3.setName("Junction-South");

        junction1.start();
        junction2.start();
        junction3.start();

        try {
            junction1.join();
            junction2.join();
            junction3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Traffic junction monitoring round completed.");
    }
}

class JunctionMonitor extends Thread {
    private String trafficStatus;
    private long monitoringInterval;

    public JunctionMonitor(String status, long interval) {
        this.trafficStatus = status;
        this.monitoringInterval = interval;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("[" + getName() + "] Status Report " + i + "/3: Traffic Status -> " + trafficStatus);
                Thread.sleep(monitoringInterval);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " monitoring interrupted.");
        }
    }
}
