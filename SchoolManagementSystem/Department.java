import java.util.Arrays;
// Salman Abdulrahman Alsaedi / 451015373
// ASSOCIATION: Department uses Employee 
public class Department {
    private int departmentId;
    private String departmentName;
    private String InchargeName;
    private String []memberList;
    public Department(int departmentId, String departmentName, String InchargeName,  String []memberList) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.InchargeName = InchargeName;
        this.memberList = memberList;
    }
    public void DepartmentDetails() {
        System.out.println("****Department Details****");
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Incharge Name: " + InchargeName);
        System.out.println("MemberList: " + Arrays.toString(memberList));
        System.out.println("****************************");

    }

    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getInchargeName() {
        return InchargeName;
    }
    public void setInchargeName(String InchargeName) {
        this.InchargeName = InchargeName;
    }
    public String[] getMemberList() {
        return memberList;
    }
    public void setMemberList(String[] memberList) {
        this.memberList = memberList;
    }


}
