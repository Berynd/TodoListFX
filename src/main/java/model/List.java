package model;

public class List {

    public List(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "List{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;
}
