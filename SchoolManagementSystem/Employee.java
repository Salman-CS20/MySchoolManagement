import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

// Salman Abdulrahman Alsaedi / 451015373
// INHERITANCE: for Teacher and SupportStaff

public class Employee {
    private int employeeId;
    private String employeeName;
    private int salary;
    private int departmentId; // ASSOCIATION: Employee uses Department
    static List<Employee> employees = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    static List<SupportStaff> supportStaffList = new ArrayList<>();

    public Employee() {}

    public Employee(int employeeId, String employeeName, int salary, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;

    }
    Scanner scanner = new Scanner(System.in);
    public void employeeDetails() {
        System.out.println( "*****Employee details*****" );
        System.out.println( "Employee Id: " + employeeId );
        System.out.println( "Employee Name: " + employeeName );
        System.out.println( "Salary: " + salary );
        System.out.println( "Department Id: " + departmentId );

    }

    public void checkIn() {
        System.out.println( employeeName + " Has Checked In at 7:30am" );
    }
    public void checkOut() {
        System.out.println( employeeName + " Has Checked Out at 2:30pm" );
    }

    public void recieveSalary() {
        System.out.println( employeeName + " Has Recieved Salary Of " + salary + "SAR" );
    }

    public void addEmployee() {
        System.out.println("--Add Employee--");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Department ID: ");
        int depId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Type (1 = Teacher, 2 = Support Staff): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            Teacher teacher = new Teacher(id, name, salary, depId, subject);
            teachers.add(teacher);
            employees.add(teacher);
            System.out.println("Teacher added successfully!");
        } else if (type == 2) {
            System.out.print("Enter Role: ");
            String role = scanner.nextLine();
            SupportStaff supportStaff = new SupportStaff(id, name, salary, depId, role);
            supportStaffList.add(supportStaff);
            employees.add(supportStaff);
            System.out.println("Support Staff added successfully!");
        } else {
            System.out.println("Invalid employee type.");
        }
    }

    public void showAllEmployee() {
        if (employees.isEmpty()) {
            System.out.println("Employee List is empty");
            return;
        }
        System.out.println("---Showing All Employees---");
        for (Employee e : employees) {
            e.employeeDetails();
            System.out.println("-------------------");
        }
    }

    public void teacherMenu() {
        boolean running = true;
        while (running) {
            System.out.println("---Teacher Menu---");
            System.out.println("1. Show Teacher Details");
            System.out.println("2. Receive Salary");
            System.out.println("3. EXIT");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers available.");
                    } else {
                        System.out.println("---All Teachers---");
                        for (Teacher t : teachers) {
                            t.employeeDetails();
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 2:
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers available.");
                    } else {
                        System.out.println("Select a Teacher to Pay Salary:");
                        for (int i = 0; i < teachers.size(); i++) {
                            System.out.println((i + 1) + ". " + teachers.get(i).getEmployeeName());
                        }
                        int teacherChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (teacherChoice >= 1 && teacherChoice <= teachers.size()) {
                            teachers.get(teacherChoice - 1).recieveSalary();
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Teacher Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 3.");
            }
        }
    }

    public void supportStaffMenu() {
        boolean running = true;
        while (running) {
            System.out.println("---Support Staff Menu---");
            System.out.println("1. Show Support Staff Details");
            System.out.println("2. Receive Salary");
            System.out.println("3. EXIT");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (supportStaffList.isEmpty()) {
                        System.out.println("No support staff available.");
                    } else {
                        System.out.println("---All Support Staff---");
                        for (SupportStaff s : supportStaffList) {
                            s.employeeDetails();
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 2:
                    if (supportStaffList.isEmpty()) {
                        System.out.println("No support staff available.");
                    } else {
                        System.out.println("Select Support Staff to Pay Salary:");
                        for (int i = 0; i < supportStaffList.size(); i++) {
                            System.out.println((i + 1) + ". " + supportStaffList.get(i).getEmployeeName());
                        }
                        int staffChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (staffChoice >= 1 && staffChoice <= supportStaffList.size()) {
                            supportStaffList.get(staffChoice - 1).recieveSalary();
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting Support Staff Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 3.");
            }
        }
    }

    public void employeeMenu() {
        boolean running = true;
        while (running) {
            System.out.println("---Employee Menu---");
            System.out.println("1. Teacher");
            System.out.println("2. Support Staff");
            System.out.println("3. EXIT");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    teacherMenu();
                    break;
                case 2:
                    supportStaffMenu();
                    break;
                case 3:
                    System.out.println("Exiting Employee Menu...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number between 1 and 3.");
            }
        }
    }

    public int  getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


}
// INHERITANCE: Teacher extends Employee
// ASSOCIATION: Inherits association from Employee (departmentId)
class Teacher extends Employee {
    String subject;
    public Teacher(int employeeId, String employeeName, int salary, int departmentId, String subject) {
        super(employeeId, employeeName, salary, departmentId);
        this.subject = subject;
    }

    public void employeeDetails() {
        super.employeeDetails();
        System.out.println( "Teacher Subject: " + subject );

    }

    public void checkIn() {
        super.checkIn();
        System.out.println( getEmployeeName() + "  Has Checked In at 7:00am" );
        System.out.println( getEmployeeName() + " Started a class");
    }

}
// INHERITANCE: SupportStaff extends Employee
// ASSOCIATION: Inherits association from Employee (departmentId)
class SupportStaff extends Employee {
    String role;
    public SupportStaff(int employeeId, String employeeName, int salary, int departmentId, String role) {
        super(employeeId, employeeName, salary, departmentId);
        this.role = role;
    }
    public void employeeDetails() {
        super.employeeDetails();
        System.out.println( "Employee Role: " + role );
    }

    public void checkIn() {
        super.checkIn();
        System.out.println( getEmployeeName() + "  Has Checked In at 7:00am" );
    }
}

