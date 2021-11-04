package tn.spring.timesheet.entities;

public class DepartementDTO {
    private int id;

    private String name;

    public DepartementDTO() {
        super();
    }

    public DepartementDTO(int id, String name) {
        this.id = id;
        this.name = name;
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
}
