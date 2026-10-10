// A1_HostelLaundryQueue.java
public class A1_HostelLaundryQueue {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        // 1. Asha starts a Quick wash on Machine M1
        m1.startWash(asha, quick);

        // 2. Ravi attempts to start a Heavy wash on Machine M1
        m1.startWash(ravi, heavy);

        // 3. Ravi starts a Heavy wash on Machine M2
        m2.startWash(ravi, heavy);

        // 4. Machine M1 completes its cycle
        m1.completeWash();

        // 5. Neha starts a Normal wash on Machine M1
        m1.startWash(neha, normal);
    }
}

interface WashType {
    String getName();
    int getDurationMinutes();
    double getCharge();
}

class QuickWash implements WashType {
    public String getName() { return "Quick"; }
    public int getDurationMinutes() { return 30; }
    public double getCharge() { return 20.0; }
}

class NormalWash implements WashType {
    public String getName() { return "Normal"; }
    public int getDurationMinutes() { return 45; }
    public double getCharge() { return 30.0; }
}

class HeavyWash implements WashType {
    public String getName() { return "Heavy"; }
    public int getDurationMinutes() { return 60; }
    public double getCharge() { return 45.0; }
}

class Student {
    private String name;
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
}

class WashingMachine {
    private String machineId;
    private boolean isBusy;
    private WashCycle currentCycle;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.isBusy = false;
        this.currentCycle = null;
    }

    public String getMachineId() { return machineId; }
    public boolean isBusy() { return isBusy; }

    public boolean startWash(Student student, WashType washType) {
        if (isBusy) {
            System.out.printf("Machine %s is currently busy.%n", machineId);
            return false;
        }
        isBusy = true;
        currentCycle = new WashCycle(student, this, washType);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: \u20B9%.2f.%n",
                washType.getName(), machineId, student.getName(), washType.getDurationMinutes(), washType.getCharge());
        return true;
    }

    public void completeWash() {
        if (isBusy) {
            isBusy = false;
            currentCycle = null;
            System.out.printf("%s cycle completed. %s is now free.%n", machineId, machineId);
        }
    }
}

class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }
}
