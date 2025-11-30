// Salman Abdulrahman Alsaedi/ 451015373
// INHERITANCE: ClassEquipment extends Equipment
public class ClassEquipment extends Equipment {
    private int classId; // ASSOCIATION: ClassEquipment used by ClassRoom
    private int benchCount;
    private int fanCount;
    private int lightCount;

    public ClassEquipment() {
        super();
    }

    public ClassEquipment(int equipmentId, double cost, int classId, int benchCount, int fanCount, int lightCount) {
        super(equipmentId, cost);
        this.classId = classId;
        this.benchCount = benchCount;
        this.fanCount = fanCount;
        this.lightCount = lightCount;
    }

    public void equipmentDetails() {
        super.equipmentDetails();
        System.out.println("Class ID: " + classId);
        System.out.println("Bench Count: " + benchCount);
        System.out.println("Fan Count: " + fanCount);
        System.out.println("Light Count: " + lightCount);
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getBenchCount() {
        return benchCount;
    }

    public void setBenchCount(int benchCount) {
        this.benchCount = benchCount;
    }

    public int getFanCount() {
        return fanCount;
    }

    public void setFanCount(int fanCount) {
        this.fanCount = fanCount;
    }

    public int getLightCount() {
        return lightCount;
    }

    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
    }
}

