import java.util.Scanner;

// Salman Abdulrahman Alsaedi/ 451015373
public class Lab {
    private int labId;
    private String labName;
    private int inChargeId; // ASSOCIATION: Lab uses Employee
    private String equipmentId; // ASSOCIATION: Lab uses Equipment

    Scanner scanner = new Scanner(System.in);
    public Lab(int labId, String labName, int inChargeId, String equipmentId) {
        this.labId = labId;
        this.labName = labName;
        this.inChargeId = inChargeId;
        this.equipmentId = equipmentId;
    }
    public boolean IsOccupied() {
        boolean occupied = false;
        if (labId > 0 && labId < 10) {
            System.out.println("Lab " + labId + " is Corrently occupied.");
            System.out.println("Statues: Occupied.");
            occupied = true;

        } else {
            System.out.println("Lab " + labId + " is Available.");
            System.out.println("Statues: Available.");

        }
        return occupied;
    }

    public void payFine() {
        System.out.println("---PAY FINE FOR DAMAGED EQUIPMENT---");
        
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        // ASSOCIATION: Lab uses Student
        for (Student s : Student.students) {
            if (s.getStudentId() == studentId) {
                found = true;
                System.out.print("Enter Equipment Name: ");
                String equipmentName = scanner.nextLine();

                System.out.print("Enter Fine Amount: ");
                double fineAmount = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("---FINE DETAILS---");
                System.out.println("Student ID: " + studentId);
                System.out.println("Student Name: " + s.getStudentName());
                System.out.println("Lab ID: " + labId);
                System.out.println("Lab Name: " + labName);
                System.out.println("Damaged Equipment: " + equipmentName);
                System.out.println("Fine Amount: " + fineAmount + " SAR");
                System.out.println("Fine has been recorded successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    public void labDetails() {
        System.out.println("---LAB Details---");
        System.out.println("Lab Id: " + labId);
        System.out.println("Lab Name: " + labName);
        System.out.println("Inche Id: " + inChargeId);
        System.out.println("Equipment Id: " + equipmentId);
        System.out.println("Statues: " + IsOccupied() );

    }
    public int getLabId() {
        return labId;
    }
    public void setLabId(int labId) {
        this.labId = labId;
    }
    public String getLabName() {
        return labName;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public int getInChargeId() {
        return inChargeId;
    }
    public void setInChargeId(int inChargeId) {
        this.inChargeId = inChargeId;
    }
    public String getEquipmentId() {
        return equipmentId;
    }
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }


}
