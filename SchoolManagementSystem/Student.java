import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Salman Abdulrahman Alsaedi/ 451015373
// INHERITANCE:  for PrimaryStudent and HigherSecondaryStudent
class Student {
    private int studentId;
    private String studentName;
    private int classId; // ASSOCIATION: Student uses Classroom
    private String section;
    private int busId; // ASSOCIATION: Student uses Bus
    private double Fees;
    private double feesPaid;
    static List<Student> students = new ArrayList<>();


    public Student() {} //Constructor just to run the studentMenu


    public Student(int studentId, String studentName, int classId, String section, int busId, double Fees) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.section = section;
        this.busId = busId;
        this.Fees = Fees;
        this.feesPaid = 0.0;


    }

    Scanner scanner = new Scanner(System.in);

    // method To Add a Student
    public void addStudent() {
        System.out.println("--ADD STUDENT---");

        System.out.print("Enter Student ID: ");

        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Class ID: ");
        int classID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Section: ");
        String sec = scanner.nextLine();


        System.out.print("Enter Student Fees: ");
        double fees = scanner.nextDouble();


        System.out.print("Enter Student Bus ID: ");
        int busID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Type (1 = Primary, 2 = Higher Secondary): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Student newStudent;
        if (type == 1) {
            newStudent = new PrimaryStudent(ID, name, classID, sec, busID, fees);
        } else {
            newStudent = new HigherSecondaryStudent(ID, name, classID, sec, busID, fees);
        }

        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Student List is empty");
            return;
        }
        System.out.println("---Showing All Students---");
        for (Student s : Student.students) {
            s.StudentDetails();
        }
    }

    // method to show all studentDetails.
    public void StudentDetails() {
        System.out.println("- Student Details -");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Class Name: " + classId);
        System.out.println("Section: " + section);
        System.out.println("bus Id: " + busId);
        System.out.println("Total Fees: " + Fees);
        System.out.println("FeesPaid: " + feesPaid);
        System.out.println("Remaining Fees: " + (Fees - feesPaid));
        System.out.println("-----------------------------------");

    }

    public void payFees(double amount) {
        if (amount <= 0) {
            System.out.println("INVALID payment amount");
            return;
        }
        if (amount + feesPaid > Fees) {
            System.out.println("You only have " + (Fees - feesPaid) + "Left, You are overpaying.");
        }
            feesPaid += amount;
            System.out.println("Student has paid: " + amount + "Succesfully.");

        if (Fees == feesPaid) {
            System.out.println(" All Fees has been paid successfully.");
        }
        System.out.println("Remaining Fees: " + (Fees - feesPaid));
    }

    public void payFeesMenu() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("Select a Student To Pay Fees for:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getStudentName());
        }

        int choice = scanner.nextInt();
        if (choice < 1 || choice > students.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Student selected = students.get(choice - 1);

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        selected.payFees(amount);

    }

    public void studentMenu() {
        boolean run = true;
        while (run) {
            System.out.println("---Student Menu---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Pay Fees");
            System.out.println("4. EXIT");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    payFeesMenu();
                    break;
                    case 4: {
                        System.out.println("Exiting Student Menu...");
                        run = false;
                    }
                default:
                    System.out.println("Invalid choice Enter a number between 1 and 4.");

            }
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getClassId() {
        return classId;
    }

    public String getSection() {
        return section;
    }

    public int getBusId() {
        return busId;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getFees() {
        return Fees;
    }
}

// INHERITANCE: HigherSecondaryStudent extends Student
// ASSOCIATION: Inherits associations from Student (classId, busId)
class HigherSecondaryStudent extends Student {

    public HigherSecondaryStudent(int studentId, String studentName, int classId, String section, int busId, double fees) {
        super(studentId, studentName, classId, section, busId, fees);
    }

    void ShowHigherStudentInfo() {
        System.out.println("This Is a Higher Secondary Student");
        super.StudentDetails();
    }
}

// INHERITANCE: PrimaryStudent extends Student
// ASSOCIATION: Inherits associations from Student (classId, busId)
class PrimaryStudent extends Student {

    public PrimaryStudent(int studentId, String studentName, int classId, String section, int busId, double fees) {
        super(studentId, studentName, classId, section, busId, fees);
    }

    public void showPrimaryStudentInfo() {
        System.out.println("This Is a Primary Student.");
        super.StudentDetails();
    }
}



