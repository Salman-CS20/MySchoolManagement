import java.util.ArrayList;
import java.util.List;

// Salman Abdulrahman Alsaedi/ 451015373
public class Main {
    public static void main (String[] args) {
        // 1. Creatimg SchoolManagement
        SchoolManagement school = new SchoolManagement();
        school.addSchoolDetails();

        // 2. Create Auditorium, Playground, Classroom, Lab, Employee, NoticeBoard
        Auditorium auditorium = new Auditorium(200);
        Playground playground = new Playground("500 square meters");
        NoticeBoard noticeBoard = new NoticeBoard("Admin");


        // Creating some ClassRooms
        ClassRoom class1 = new ClassRoom(1, "Class 1", 0, 0, 1);
        ClassRoom class2 = new ClassRoom(2, "Class 2", 0, 0, 2);
        ClassRoom class3 = new ClassRoom(3, "Class 3", 0, 0, 3);
        ClassRoom.classrooms.add(class1);
        ClassRoom.classrooms.add(class2);
        ClassRoom.classrooms.add(class3);

        // Creating some Labs
        List<Lab> labs = new ArrayList<>();
        Lab lab1 = new Lab(1, "Computer Lab", 101, "CC01");
        Lab lab2 = new Lab(2, "Science Lab", 102, "SC02");
        labs.add(lab1);
        labs.add(lab2);

        // Create some Employees
        Teacher teacher1 = new Teacher(101, "Mr. Ahmed", 8000, 1, "Mathematics");
        Teacher teacher2 = new Teacher(102, "Ms. Saad", 7500, 2, "English");
        SupportStaff staff1 = new SupportStaff(201, "Ali", 4000, 3, "Bus Driver");
        Employee.teachers.add(teacher1);
        Employee.teachers.add(teacher2);
        Employee.supportStaffList.add(staff1);
        Employee.employees.add(teacher1);
        Employee.employees.add(teacher2);
        Employee.employees.add(staff1);

        // 3. Initialize (To pass the objects to SchoolManagement)
        school.Initialize(auditorium, playground, labs, noticeBoard);

        // Add some students
        Student.students.add(new PrimaryStudent(1, "Gassan", 1, "A", 101, 5000));
        Student.students.add(new PrimaryStudent(2, "Salman", 2, "B", 102, 6000));
        Student.students.add(new HigherSecondaryStudent(3, "Assaf", 3, "C", 103, 7000));

        // 4. Run School
        school.schoolDetails();
    }
}

