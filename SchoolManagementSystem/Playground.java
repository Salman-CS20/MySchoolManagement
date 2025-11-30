import java.util.Scanner;

// AGGREGATION: Playground aggregated by SchoolManagement
public class Playground {

    String area;
    int classId; // ASSOCIATION: Playground used by ClassRoom
    Scanner scanner = new Scanner(System.in);

    public Playground() {
        area = "";
        classId = 0;
    }

    public Playground(String area) {
        this.area = area;
        classId = 0;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getArea() {
        return area;
    }

    public int getClassId() {
        return classId;
    }

    // Method to book the playground for a class
    public void bookPlayground() {
        System.out.println("---BOOKING PLAYGROUND---");
        
        if (classId != 0) {
            System.out.println("Playground is occupied by class: " + classId);
            System.out.println(" You Should Release it before booking for another class.");
            return;
        }

        System.out.print("Enter Class ID to book playground: ");
        int newClassId = scanner.nextInt();
        scanner.nextLine();

        if (newClassId <= 0) {
            System.out.println("INVALID, Class ID must be greater than 0");
            return;
        }

        // Check if the class exists in the classrooms list
        boolean Exists = false;
        for (ClassRoom classroom : ClassRoom.classrooms) {
            if (classroom.getClassId() == newClassId) {
                Exists = true;
                break;
            }
        }

        if (!Exists) {
            System.out.println("Class ID " + newClassId + " not found. Please enter a valid class ID.");
            return;
        }

        this.classId = newClassId;
        System.out.println("Playground has been booked successfully for Class : " + classId);
        System.out.println("Area of the PlayGround is: " + "(" + area + ")");
    }

    // Method to Release the playground
    public void releasePlayground() {
        System.out.println("---RELEASING THE PLAYGROUND---");
        
        if (classId == 0) {
            System.out.println("Playground is already free. No class is currently using it.");
            return;
        }

        
        this.classId = 0;
        System.out.println("Playground has been released successfully from Class ID: " + classId);
        System.out.println("Playground is now available for booking.");
    }

    // Method to check if playground is occupied
    public void isOccupied() {
        if (classId != 0) {
            System.out.println("Playground is occupied by class: " + classId);
        } else {
            System.out.println("Playground is free.");
        }
    }

    // Method to display playground details
    public void showPlaygroundDetails() {
        System.out.println("****PLAYGROUND DETAILS****");
        System.out.println("Area: " + area);
        if (classId != 0) {
            System.out.println("Status: Occupied");
            System.out.println("Occupied by Class ID: " + classId);
        } else {
            System.out.println("Status: Available");
        }
        System.out.println("**************************");
    }

    // Playground menu
    public void PlaygroundMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("---PLAYGROUND MENU---");
            System.out.println("1. Book Playground");
            System.out.println("2. Release Playground");
            System.out.println("3. Check if Occupied");
            System.out.println("4. Display Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    bookPlayground();
                    break;
                case 2:
                    releasePlayground();
                    break;
                case 3:
                    isOccupied();
                    break;
                case 4:
                    showPlaygroundDetails();
                    break;
                case 5:
                    System.out.println("Exiting Playground Menu...");
                    flag = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE, enter a number between 1-5");
            }
        }
    }
}


