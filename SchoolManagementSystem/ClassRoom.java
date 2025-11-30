import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Implemented by: Abdulrahim Obaid - ID: 441000953
public class ClassRoom {
    private int classId;
    private  String className;
    private  int teacherId; // ASSOCIATION: ClassRoom uses Teacher
    private int studentCount;
    private int equipmentId; // ASSOCIATION: ClassRoom uses Equipment
    private List<Integer> studentIds = new ArrayList<>();
    static List<ClassRoom> classrooms = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public ClassRoom() {}

    public ClassRoom (int classId, String className, int teacherId, int studentCount, int equipmentId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
        this.studentCount = studentCount;
        this.equipmentId = equipmentId;
    }
        // ClassDetails()
        public void ClassDetails() {
            System.out.println("***** Classroom Details *****");
            System.out.println("Class ID      : " + classId);
            System.out.println("Class Name    : " + className);
            System.out.println("Teacher ID    : " + teacherId);
            System.out.println("Student Count : " + studentCount);
            System.out.println("Equipment ID  : " + equipmentId);
            System.out.println("*****************************");
        }

        public void showClassDetails() {
            if (classrooms.isEmpty()) {
                System.out.println("No classrooms available.");
                return;
            }
            System.out.println("Select a Classroom to Show Details:");
            for (int i = 0; i < classrooms.size(); i++) {
                System.out.println((i + 1) + ". " + classrooms.get(i).className +
                        " (ID: " + classrooms.get(i).classId + ")");
            }
            int classChoice = scanner.nextInt();
            scanner.nextLine();

            if (classChoice < 1 || classChoice > classrooms.size()) {
                System.out.println("Invalid choice.");
                return;
            }
            ClassRoom selectedClass = classrooms.get(classChoice - 1);
            selectedClass.ClassDetails();
        }


                     // Salman Abdulrahman Alsaedi/ 451015373
    public void addStudents() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available. Select a classroom first.");
            return;
        }
            System.out.println("Select a Classroom:");
            for (int i = 0; i < classrooms.size(); i++) {
                System.out.println((i + 1) + ". " + classrooms.get(i).className + " (ID: " + classrooms.get(i).classId + ")");
            }
            int classChoice = scanner.nextInt();
            scanner.nextLine();

            if (classChoice > 1 || classChoice > classrooms.size()) {
                System.out.println("Invalid choice.");
            }

        ClassRoom selectedClass = classrooms.get(classChoice - 1);

        if (Student.students.isEmpty()) {
            System.out.println("No students available. Add students first.");
            return;
        }

        System.out.println("---ADD STUDENTS TO CLASS---");
        System.out.println("Available Students:");
        // ASSOCIATION: ClassRoom uses Student 
        for (Student s : Student.students) {
            System.out.println("ID: " + s.getStudentId() + " - " + s.getStudentName() + " (Class: " + s.getClassId() + ")");
        }

        System.out.print("Enter Student ID to add: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Student s : Student.students) {
            if (s.getStudentId() == studentId) {
                if (s.getClassId() == selectedClass.classId) {
                    if (!studentIds.contains(studentId)) {
                        selectedClass.studentIds.add(studentId);
                        selectedClass.studentCount++;
                        System.out.println("Student added to class successfully!");
                    } else {
                        System.out.println("Student already in this class.");
                    }
                } else {
                    System.out.println("Student belongs to a different class.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student ID not found.");
        }
    }

    public void assignTeacher() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available. Select a classroom first.");
            return;
        }

        System.out.println("Select a Classroom:");
        for (int i = 0; i < classrooms.size(); i++) {
            System.out.println((i + 1) + ". " + classrooms.get(i).className +
                    " (ID: " + classrooms.get(i).classId + ")");
        }

        int classChoice = scanner.nextInt();
        scanner.nextLine();

        if (classChoice < 1 || classChoice > classrooms.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        ClassRoom selectedClass = classrooms.get(classChoice - 1);

        System.out.println("---ASSIGN TEACHER---");
        System.out.print("Enter Teacher ID: ");
        int teacherId = scanner.nextInt();
        scanner.nextLine();

        selectedClass.teacherId = teacherId;
        System.out.println("Teacher assigned successfully!");
    }


    public void classMenu() {
        boolean run = true;
        while (run) {
            System.out.println("---CLASS MENU---");
            System.out.println("1. Add Students (by StudentID)");
            System.out.println("2. Assign Teacher (by TeacherID)");
            System.out.println("3. Show Details");
            System.out.println("4. EXIT");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    assignTeacher();
                    break;
                case 3:
                    showClassDetails();
                    break;
                case 4:
                    System.out.println("Exiting Class Menu...");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 4.");
            }
        }
    }

    public int getClassId() {
        return classId;
    }
    public String getClassName(){
        return className;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    public int getTeacherId() {
        return teacherId;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
    public int getStudentCount() {
        return studentCount;
    }
    public int getEquipmentId() {
        return equipmentId;
    }




}
