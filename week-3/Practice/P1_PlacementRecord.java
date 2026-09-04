public class P1_PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public P1_PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        P1_PlacementRecord[] records = {
            new P1_PlacementRecord("Ravi", "TCS", 4.5),
            new P1_PlacementRecord("Anitha", "Zoho", 6.2),
            new P1_PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (P1_PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
