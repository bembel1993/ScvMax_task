package table_1;

public class Employee {

    private int id;
    private String name;
    private int mass;
    private String single;
    private int room;
    private int dep;

    public Employee(int id, String name, int mass, String single, int room, int dep) {
        this.id = id;
        this.name = name;
        this.mass = mass;
        this.single = single;
        this.room = room;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public void showEmp() {
        System.out.println(id+ "; " + name+"; " + mass+"; " + single+"; " + room+"; " + dep);
    }

    @Override
    public String toString() {
        return "\nId=" + getId() + ";name=" + getName() + ";mass="
                + getMass() + ";single=" + getSingle() + ";room=" + getRoom()
                + ";dep=" + getDep();
    }
}
