import java.util.Scanner;

// Implemented by: Abdulrahim Obaid, ID: 441000953
// INHERITANCE:  For ClassEquipment and LabEquipment
public class Equipment {
    private int equipmentId;
    private double cost;

    Scanner scanner = new Scanner(System.in);

    public Equipment() {}

    public Equipment(int equipmentId, double cost) {
        this.equipmentId = equipmentId;
        this.cost = cost;
    }

    public void equipmentDetails() {
        System.out.println("---Equipment Details---");
        System.out.println("Equipment ID: " + equipmentId);
        System.out.println("Cost: " + cost + " SAR");
    }

    public void purchaseEquipment() {
        System.out.println("---Purchase Equipment---");
        System.out.print("Enter Equipment ID: ");
        this.equipmentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Cost: ");
        this.cost = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Equipment purchased successfully!");
        equipmentDetails();
    }

    public void repair() {
        System.out.println("Equipment: " + equipmentId + " has been sent for repair.");
        System.out.println("The Repair cost: " + (cost) + " SAR");
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

