import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Salman Abdulrahman Alsaedi/ 451015373
// ASSOCIATION: Bus used by Student
public class Bus {
    private int busId;
    private int driverId;
    private String busNumber;
    private int capacity;
    List<String> areaList =  new ArrayList<>();
    static List<Bus> buses = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    public Bus() {}

    public Bus(int busId, int driverId, String busNumber, int capacity) {
        this.busId = busId;
        this.driverId = driverId;
        this.busNumber = busNumber;
        this.capacity = capacity;

    }

    public void addBus() {
        System.out.println("---ADD BUS---");
        System.out.print("Enter Bus ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Bus Number: ");
        String busNumber = scanner.nextLine();

        System.out.print("Enter Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("How many areas does this bus visit? ");
        int areaCount = scanner.nextInt();
        scanner.nextLine();

        List<String> areas = new ArrayList<>();
        for (int i = 0; i < areaCount; i++) {
            System.out.print("Enter Area " + (i + 1) + ": "); // To start from 1 instead of 0
            areas.add(scanner.nextLine());
        }

        Bus newBus = new Bus(id, driverId, busNumber, capacity);
        newBus.areaList = areas;
        buses.add(newBus);

        System.out.println("Bus Added Successfully!");
    }

    public void busDetails(){
        if (buses.isEmpty()) {
            System.out.println("No Bus Available!, Add a Bus First");
            return;
        }

        System.out.println("---ALL BUS DETAILS---");
        for (Bus bus : buses) {
            System.out.println("---BUS DETAILS---");
            System.out.println("Bus ID: " + bus.busId);
            System.out.println("Driver ID: " + bus.driverId);
            System.out.println("Bus Number: " + bus.busNumber);
            System.out.println("Capacity: " + bus.capacity);
            System.out.println("Areas: " + bus.areaList);
            System.out.println("-------------------");
        }
    }

    public void showSeats(){
       if (buses.isEmpty()) {
           System.out.println("No Bus Available!, you should Add a Bus First");
           return;
       }

       System.out.println("Select a Bus to Show Seats for:");
       for (int i = 0; i < buses.size(); i++) {
           System.out.println((i + 1) + ". Bus ID: " + buses.get(i).busId + " - " + buses.get(i).busNumber);
       }

       int choice = scanner.nextInt();
       scanner.nextLine();

       if (choice < 1 || choice > buses.size()) {
           System.out.println("Invalid choice.");
           return;
       }

       Bus selectedBus = buses.get(choice - 1);
       System.out.println("---SEAT DETAILS---");
       System.out.println("Bus ID: " + selectedBus.busId);
       System.out.println("Bus Number: " + selectedBus.busNumber);
       System.out.println("Total Seats: " + selectedBus.capacity);
    }

    public void busMenu() {
        boolean run = true;
        while (run) {
            System.out.println("---Bus Menu---");
            System.out.println("1. Add Bus");
            System.out.println("2. Show Bus Details");
            System.out.println("3. Show Seats");
            System.out.println("4. EXIT");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                   addBus();
                    break;
                case 2:
                    busDetails();
                    break;
                case 3:
                    showSeats();
                    break;
                case 4: {
                    System.out.println("Exiting Bus Menu...");
                    run = false;
                }
                default:
                    System.out.println("Invalid choice Enter a number between 1 and 3.");

            }
        }
    }


}
