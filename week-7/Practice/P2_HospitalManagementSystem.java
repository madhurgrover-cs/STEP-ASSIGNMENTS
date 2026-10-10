// P2_HospitalManagementSystem.java
public class P2_HospitalManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System ===");

        Doctor doc1 = new Doctor(1, "Sarah Connor", "Cardiology", 150.0);
        Doctor doc2 = new Doctor(2, "Gregory House", "Neurology", 200.0);

        Patient p1 = new Patient(101, "John Doe", "Heart Arrhythmia", 45);
        Patient p2 = new Patient(102, "Jane Smith", "Migraine", 30);
        Patient p3 = new Patient(103, "Robert Paulson", "Coronary Artery Disease", 52);

        // Assign patients based on specialization
        for (Patient p : new Patient[]{p1, p2, p3}) {
            if (p.getDisease().toLowerCase().contains("heart") || p.getDisease().toLowerCase().contains("coronary")) {
                p.assignDoctor(doc1);
            } else if (p.getDisease().toLowerCase().contains("migraine") || p.getDisease().toLowerCase().contains("neuro")) {
                p.assignDoctor(doc2);
            } else {
                p.assignDoctor(doc1);
            }
        }

        System.out.println("\n--- Patient & Assigned Doctor Details ---");
        for (Patient p : new Patient[]{p1, p2, p3}) {
            p.displayDetails();
            System.out.println("----------------------------------------");
        }

        System.out.println("\n--- Total Consultation Fees Collected ---");
        System.out.println("Dr. " + doc1.getName() + " (" + doc1.getSpecialization() + "):");
        System.out.println("  Patients Assigned  : " + doc1.getPatientCount());
        System.out.println("  Total Fee Collected: $" + doc1.calculateTotalFee());

        System.out.println("\nDr. " + doc2.getName() + " (" + doc2.getSpecialization() + "):");
        System.out.println("  Patients Assigned  : " + doc2.getPatientCount());
        System.out.println("  Total Fee Collected: $" + doc2.calculateTotalFee());
    }
}

class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private int patientCount;

    public Doctor(int doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patientCount = 0;
    }

    public int getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }
    public int getPatientCount() { return patientCount; }

    public void incrementPatientCount() { this.patientCount++; }
    public double calculateTotalFee() { return consultationFee * patientCount; }

    public void displayDetails() {
        System.out.println("Doctor ID       : " + doctorId);
        System.out.println("Name            : Dr. " + name);
        System.out.println("Specialization  : " + specialization);
        System.out.println("Consultation Fee: $" + consultationFee);
    }
}

class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;
    private Doctor assignedDoctor;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
        this.assignedDoctor = null;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getDisease() { return disease; }
    public int getAge() { return age; }
    public Doctor getAssignedDoctor() { return assignedDoctor; }

    public void assignDoctor(Doctor doc) {
        this.assignedDoctor = doc;
        doc.incrementPatientCount();
    }

    public void displayDetails() {
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Disease        : " + disease);
        if (assignedDoctor != null) {
            System.out.println("Assigned Doctor: Dr. " + assignedDoctor.getName() + " (" + assignedDoctor.getSpecialization() + ")");
        } else {
            System.out.println("Assigned Doctor: Unassigned");
        }
    }
}
