import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
// Salman  Abdulrahman Alsaedi / 451015373
// ASSOCIATION: SchoolManagement uses Auditorium 
// AGGREGATION: SchoolManagement aggregates Playground, ClassRooms, Labs, Employees, NoticeBoard 
  class SchoolManagement {
      String SchoolName, Address, ContactNumber, MediumOfStudy;
      Auditorium auditorium; // ASSOCIATION: SchoolManagement uses Auditorium
      Playground playground; // AGGREGATION: SchoolManagement aggregates Playground
      List<ClassRoom> classrooms = new ArrayList<>(); // AGGREGATION: SchoolManagement aggregate classrooms
      List<Lab> labs = new ArrayList<>(); // AGGREGATION: SchoolManagement aggregate Labs
      List<Employee> employees = new ArrayList<>(); // AGGREGATION: SchoolManagement aggregate Employees
      NoticeBoard noticeBoard; // AGGREGATION: SchoolManagement aggregate NoticeBoard


    Scanner scanner = new Scanner(System.in);
      public SchoolManagement() {
          this.scanner = new Scanner(System.in);
      }

      public void addSchoolDetails() {
          System.out.println("---ADD SCHOOL DETAILS---");
          System.out.print("Enter School Name: ");
          this.SchoolName = scanner.nextLine();

          System.out.print("Enter Address: ");
          this.Address = scanner.nextLine();

          System.out.print("Enter Contact Number: ");
          this.ContactNumber = scanner.nextLine();

          System.out.print("Enter Medium of Study: ");
          this.MediumOfStudy = scanner.nextLine();

          System.out.println("School details added successfully!");
      }

      public String getSchoolName() {
          return SchoolName;
      }

      public String getAddress() {
          return Address;
      }

      public String getContactNumber() {
          return ContactNumber;
      }

      public String getMediumOfStudy() {
          return MediumOfStudy;
      }

      public void ShowSchoolDetails() {
          if (SchoolName == null || SchoolName.isEmpty()) {
              System.out.println("School details not set. Please add school details first.");
              return;
          }
          System.out.println("--School Details--");
          System.out.println("School Name: " + getSchoolName());
          System.out.println("Address: " + getAddress());
          System.out.println("Contact Number: " + getContactNumber());
          System.out.println("Medium of Study: " + getMediumOfStudy());
      }


      public void Initialize(Auditorium auditorium, Playground playground, List<Lab> labs, NoticeBoard noticeBoard) {

          this.auditorium = auditorium;
          this.playground = playground;
          this.labs = labs;
          this.noticeBoard = noticeBoard;

      }

      // method to check if the school open
      public boolean isOpen() {
          System.out.print("Enter a day in the week: ");
          String Day = scanner.nextLine();

          if (Day.equals("friday") || Day.equals("saturday")) {
              return false;

          } else {
              return true;
          }
      }

      // Main school menu
      public void schoolDetails() {
          if (!isOpen()) {
              System.out.println("School Is Not Open Today.");
              return;
          }
          boolean isOpen = true;
          int choice;

          while (isOpen) {
              System.out.println("*******************************");
              System.out.println("Welcome to our School Management");
              System.out.println("1. Bus: ");
              System.out.println("2. Student: ");
              System.out.println("3. Employee: ");
              System.out.println("4. Class: ");
              System.out.println("5. NoticeBoard: ");
              System.out.println("6. Auditorium: ");
              System.out.println("7. Playground: ");
              System.out.println("8. ShowSchoolDetails: ");
              System.out.println("9. EXIT");
              System.out.println("*******************************");

              System.out.print("Enter Your Choice (1-9): ");
              choice = scanner.nextInt();
              scanner.nextLine();

              switch (choice) {

                  case 1 ->{
                          System.out.println("Showing Bus Menu...");
                          Bus b = new Bus();
                          b.busMenu();
                  }
                  case 2 -> {
                      System.out.println("Showing Student Menu...");
                      Student s = new Student();
                      s.studentMenu();
                  }


                  case 3 -> {
                      System.out.println("Showing Employee Menu...");
                      Employee emp = new Employee();
                      emp.employeeMenu();
                  }
                  case 4 -> {
                      System.out.println("Showing Class Menu...");
                      ClassRoom CR = new ClassRoom();
                      CR.classMenu();
                  }
                  case 5 -> {
                      System.out.println("Showing NoticeBoard Menu...");
                      NoticeBoard NB = new NoticeBoard();
                      NB.NoticeBoardMenu();
                  }

                  case 6 -> {
                      System.out.println("Showing Auditorium Menu...");
                       Auditorium aud = new Auditorium(400);
                       aud.AudiotoriumMenu();
              }
                  case 7 -> {
                      System.out.println("Showing Playground Menu...");
                      Playground PG = new Playground("500 square meters");
                      PG.PlaygroundMenu();
                  }
                  case 8 -> {
                      System.out.println("Showing School Details...");
                      ShowSchoolDetails();
                  }
                  case 9 -> {
                      System.out.println("Exiting...");
                      isOpen = false;
                  }
                  default -> System.out.println("INVALID CHOICE, enter a number Between 1-9");
              }

          }

      }

  }