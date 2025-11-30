import java.util.Scanner;

// Salman Abdulrahman Alsaedi/ 451015373
// ASSOCIATION: Auditorium used by SchoolManagement
public class Auditorium {
    private int totalSeats;
    private int seatsOccupied;
    private String eventName;
    private String eventDate;
    private String eventTime;


    Scanner Scanner = new Scanner(System.in);

    public Auditorium() {
    }

    public Auditorium(int totalSeats) {
        this.totalSeats = totalSeats;
        this.seatsOccupied = 0;
        this.eventName = "";
        this.eventDate = "";
        this.eventTime = "";

    }
    // Just To add an Event. It don't book one
    public void addEvent() {
        System.out.println("---ADD AN EVENT---");

        System.out.print("Enter Event Name: ");
        Scanner.nextLine();
        this.eventName = Scanner.nextLine();

        System.out.print("Enter Event Date: ");
        this.eventDate = Scanner.nextLine();

        System.out.print("Enter Event Time: ");
        this.eventTime = Scanner.nextLine();


        System.out.println("Event Added Successfully!");
    }

    // Method to book an event in the auditorium
    public void BookAuditorium() {
        System.out.println("---BOOK AUDITORIUM---");
        
        System.out.print("Enter Event Name: ");
        Scanner.nextLine();
        String eventName = Scanner.nextLine();

        System.out.print("Enter Event Date: ");
        String eventDate = Scanner.nextLine();

        System.out.print("Enter Event Time: ");
        String eventTime = Scanner.nextLine();

        System.out.print("Enter Number of Seats to Book: ");
        int seatsToBook = Scanner.nextInt();
        Scanner.nextLine();

        if (seatsToBook <= 0) {
            System.out.println("INVALID, Number of Seats must be greater than 0");
            return;
        }
        if (seatsOccupied + seatsToBook > totalSeats) {
            System.out.println("Not enough seats available. Available seats: " + (totalSeats - seatsOccupied));
            return;
        }

        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.seatsOccupied += seatsToBook;

        System.out.println("Auditorium Have Been Booked Successfully For Event: " + eventName);
        System.out.println("Seats Booked: " + seatsToBook);
        System.out.println("Total Seats Occupied: " + seatsOccupied + "/" + totalSeats);
    }

    public void EventDetails() {
        System.out.println("****AUDITORIUM EVENT DETAILS**** ");
        System.out.println("Event Name: " + eventName);
        System.out.println("Event Date: " + eventDate);
        System.out.println("Event Time: " + eventTime);
        System.out.println("Total Seats: " + seatsOccupied + "/" + totalSeats);
        System.out.println("**********************************");

    }

    public void DisplaySeats() {
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Seats Occupied: " + seatsOccupied);
        System.out.println("Available Seats: " + (totalSeats - seatsOccupied));

    }

    public void AudiotoriumMenu() {
        boolean flag = true;
        while (flag) {

            System.out.println("---AUDITORIUM MENU---");
            System.out.println("1.Add an Event ");
            System.out.println("2. Book Auditorium ");
            System.out.println("3. Show Event Details");
            System.out.println("4. Display Seats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Scanner.nextInt();
            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    BookAuditorium();
                    break;
                case 3:
                    EventDetails();
                    break;
                case 4:
                    DisplaySeats();
                    break;
                    case 5: {
                        System.out.println("Exiting Audiotorium Menu...");
                        flag = false;
                    }
            }
        }
    }





    public int getTotalSeats() {
        return totalSeats;
    }
    public String getEventName() {
        return eventName;
    }
    public String getEventDate() {
        return eventDate;
    }
    public String getEventTime() {
        return eventTime;
    }
    public int getSeatsOccupied() {
        return seatsOccupied;
    }

}
